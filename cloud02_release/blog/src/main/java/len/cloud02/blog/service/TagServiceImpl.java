package len.cloud02.blog.service;

import len.cloud02.blog.dao.TagRepository;
import len.cloud02.blog.error.NotFoundException;
import len.cloud02.blog.util.LenList;
import len.cloud02.blog.pojo.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TagRepository tagRepository;

    @Transactional  // 放在事务里。增删改需要放在事务里，但是查询不需要放在事务里
    @Override
    public Tag saveTag(Tag Tag) {
        return tagRepository.save(Tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);  // return TagRepository.findOne(id);报错的改为return TagRepository.getOne(id);或者return TagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        // 用于根据传回的多个id，来返回所有的Tag
        return tagRepository.findAllById(LenList.string2list(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagRepository.LenfindTop(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag Tag_new) {
        Tag Tag_old = tagRepository.getOne(id);
        if (Tag_old==null){
            throw new NotFoundException("不存在该类型！");
        }
        BeanUtils.copyProperties(Tag_new, Tag_old);
        return tagRepository.save(Tag_old);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);  // TagRepository.delete(id)换成TagRepository.deleteById(id)
    }

}
