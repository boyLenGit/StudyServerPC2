package len.cloud02.blog.web.blog;

import len.cloud02.blog.service.BlogService;
import len.cloud02.blog.service.TagService;
import len.cloud02.blog.service.TypeService;
import len.cloud02.blog.vo.BlogQuery;
import len.cloud02.blog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogUserController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public String getBlogList(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "blog/article_list";
    }

    // 博客管理页-条件查询
    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        // ~解释@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC)
        //      ·让pageable按照updateTime更新时间倒序排序，每页2条
        Page<Blog> result = blogService.listBlog(pageable, blog);
        model.addAttribute("page", result);
        return "blog/list :: blogList";  // 返回页面admin_article下的blogList片段
    }
}
