package len.cloud01.artifact.web;

import len.cloud01.artifact.po.Comment;
import len.cloud01.artifact.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{blogId}")
    public String Comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "article :: commentList";
    }

    @GetMapping("/comments")
    public String post(Comment comment){
        return "redirect:/comments/" + comment.getBlog().getId();
    }
}
