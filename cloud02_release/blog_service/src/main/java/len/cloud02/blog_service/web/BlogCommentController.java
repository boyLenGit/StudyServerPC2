package len.cloud02.blog_service.web;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Comment;
import len.cloud02.blog_service.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 23:04
 */
@Controller
@ResponseBody
@RequestMapping("/blog/comment")
public class BlogCommentController {
    @Autowired
    private BlogCommentService blogCommentService;

    @GetMapping("/list")
    public JSONObject list(@RequestParam Long blogId){
        return blogCommentService.getBlogCommentList(blogId);
    }

    @PostMapping("/add")
    public JSONObject add(@RequestBody Comment comment){
        return blogCommentService.addBlogComment(comment);
    }
}
