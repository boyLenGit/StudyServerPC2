package len.cloud02.blog.web;

import len.cloud02.blog.service.BlogService;
import len.cloud02.blog.service.CommentService;
import len.cloud02.blog.service.TagService;
import len.cloud02.blog.service.TypeService;
import len.cloud02.blog.pojo.Blog;
import len.cloud02.blog.util.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        model.addAttribute("query", "");
        LenLog.staticInfo("index", Integer.toString(blogService.listRecommendBlogTop(8).size()));
        return "index";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model){
        Page<Blog> result = blogService.listBlog("%"+query+"%", pageable);
        LenLog.staticInfo("search", query);
        LenLog.staticInfo("search", String.valueOf(pageable));
        LenLog.staticInfo("search", result.toString());
        model.addAttribute("page", result);
        model.addAttribute("query", query);
        return "blog/search";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable Long id, Model model){
        model.addAttribute("blog", blogService.getAndConvert(id));
        model.addAttribute("comments", commentService.listCommentByBlogIdAndParentCommentNull(id));
        return "blog/article_detail";
    }

    @GetMapping("/features")
    public String features(){
        return "features";
    }

    @GetMapping("/workflows")
    public String workflows(){
        return "workflows";
    }
}
