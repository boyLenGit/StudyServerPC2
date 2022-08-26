package len.cloud02.front.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Blog;
import len.cloud02.front.entity.PageInfo;
import len.cloud02.front.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 22:49
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public String list(){
        return "blog/blogList";
    }


    @PostMapping("/list.data")
    public String listByPage(Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        JSONObject jsonObject = blogService.getBlogList(pageNum, pageSize);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        List<Blog> blogList = jsonArray.toJavaList(Blog.class);
        blogService.initBlogList(blogList);
        PageInfo pageInfo = new PageInfo(jsonObject);
        model.addAttribute("page", pageInfo);
        model.addAttribute("blogs", blogList);
        return "blog/blogList :: blogList";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam Long id){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/blogDetail";
    }

    @PostMapping("/detail.data")
    public String detailData(Model model, @RequestParam Long id){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/blogDetail :: blogFragment";
    }

    @GetMapping("/likeBlog")
    @ResponseBody
    public JSONObject likeBlog(@RequestParam(required = true)Long id){
        System.out.println("likeBlog");
        blogService.likeBlog(id);
        return new JSONObject();
    }

    @GetMapping("/dislikeBlog")
    @ResponseBody
    public JSONObject dislikeBlog(@RequestParam(required = true)Long id){
        blogService.dislikeBlog(id);
        return new JSONObject();
    }
}
