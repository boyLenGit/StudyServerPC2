package len.cloud02.front.web;

import len.cloud02.front.entity.Comment;
import len.cloud02.front.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 22:46
 */
@Controller
@RequestMapping("/blog/comment")
public class BlogCommentController {
    @Autowired
    private BlogCommentService blogCommentService;

    @PostMapping("/add")
    public String add(Comment comment, @RequestParam Long blogUserId){
        boolean b = blogCommentService.addBlogComment(comment, blogUserId);
        return "redirect:/blog/detail?id="+comment.getBlogId();
    }

    @PostMapping("/list")
    public String list(@RequestParam Long blogId, Model model){
        List<Comment> blogCommentList = blogCommentService.getBlogCommentList(blogId);
        model.addAttribute("comments", blogCommentList);
        return "/blog/blogDetail :: commentList";
    }
}
