package len.cloud02.blog_service.web;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Blog;
import len.cloud02.blog_service.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/19 13:46
 */
@Controller
@ResponseBody
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/getBlogById")
    public Blog getBlogById(@RequestParam(required = true)Long id){
        return blogService.getBlogById(id);
    }

    @GetMapping("/likeBlog")
    public JSONObject likeBlog(@RequestParam(required = true)Long id){
        blogService.likeOrDislikeBlog(id, 1);
        return new JSONObject().fluentPut("msg", true);
    }

    @GetMapping("/dislikeBlog")
    public JSONObject dislikeBlog(@RequestParam(required = true)Long id){
        blogService.likeOrDislikeBlog(id, -1);
        return new JSONObject().fluentPut("msg", true);
    }

    @GetMapping("/getBlogLiteListByPage")
    public JSONObject getBlogLiteListByPage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return blogService.getBlogLiteListByPage(pageNum-1, pageSize);
    }

    @GetMapping("/getBlogListByPage")
    public JSONObject getBlogListByPage(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return blogService.getBlogListByPage(pageNum-1, pageSize);
    }


}
