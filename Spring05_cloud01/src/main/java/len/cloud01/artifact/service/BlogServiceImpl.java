package len.cloud01.artifact.service;

import len.cloud01.artifact.dao.BlogRepository;
import len.cloud01.artifact.error.NotFoundException;
import len.cloud01.artifact.po.Blog;
import len.cloud01.artifact.po.Tag;
import len.cloud01.artifact.po.Type;
import len.cloud01.artifact.util.LenBeanUtils;
import len.cloud01.artifact.util.MarkdownUtils;
import len.cloud01.artifact.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if(blog==null){
            throw new NotFoundException("该博客不存在");
        }
        String content = blog.getContent();
        MarkdownUtils.markdownToHtmlExtensions(content);
        blog.setContent(content);
        return blog;
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findByQuery(query, pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override // 根据条件生成项目表pageable的动态组合
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                // 用于处理动态查询条件
                List<Predicate> predicates = new ArrayList<>();
                // ↓ 按标题筛选
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add(cb.like(root.<String>get("title"), "%"+blog.getTitle()+"%"));
                }
                // ↓ 按分类筛选
                if (blog.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                // ↓ 按是否推荐筛选
                if (blog.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                // ↓ 执行CriteriaQuery查询
                //      ·predicates.size()用于指定Predicate的大小长度
                //      ·predicates.toArray用于把where查询到的数据转化成为数组
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");
        Pageable pageable = PageRequest.of(0, size, sort);
        return blogRepository.LenfindTop(pageable);
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        return null;
    }

    @Override
    public Long countBlog() {
        return null;
    }

    @Transactional  // 增删改加入到事务中
    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null) {
            // 如果是新增博客，则初始化博客的一些属性
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);  // 设置浏览次数，初始化值
        }else {
            blog.setUpdateTime(new Date());
        }

        return blogRepository.save(blog);
    }

    @Transactional  // 增删改加入到事务中
    @Override
    public Blog updateBlog(Long id, Blog blog_from_html) {
        Blog blog_to_save = blogRepository.getOne(id);
        if (blog_to_save==null){
            throw new NotFoundException("不存在该类型！");
        }
        BeanUtils.copyProperties(blog_from_html, blog_to_save, LenBeanUtils.getNullPropertyNames(blog_from_html));
        // ↑ getNullPropertyNames用于将blog_from_html中的空属性过滤掉，以免让数据库中的部分值被替换为null
        blog_to_save.setUpdateTime(new Date());
        return blogRepository.save(blog_to_save);
    }

    @Transactional  // 增删改加入到事务中
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
