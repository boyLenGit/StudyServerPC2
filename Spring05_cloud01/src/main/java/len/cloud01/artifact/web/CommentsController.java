package len.cloud01.artifact.web;

import len.cloud01.artifact.po.Comment;
import len.cloud01.artifact.service.BlogService;
import len.cloud01.artifact.service.CommentService;
import len.cloud01.artifact.util.base.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    // ↓ 这个comment.avatar位于/resources/application-dev.yml
    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String Comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        LenLog.staticInfo("comments-Comments", commentService.listCommentByBlogId(blogId).toString());
        return "article :: commentList";
    }

    // 网页提交评论内容
    @PostMapping("/comments")
    public String post(Comment comment){
        LenLog.staticInfo("Comment-post", comment.toString());
        Long blogId = comment.getBlog().getId();
        // 用于实例化Comment对象中的Blog。
        // 【方法】到底哪些对象需要在这里单独实例化？→查看web端与Comment对象，看看哪些变量传递进去了，哪些没传递进去，没传递进去的就是需要实例化/填充的，否则Comment部分属性为空。
        comment.setBlog(blogService.getBlog(blogId));
        comment.setAvatar(avatar);
        commentService.saveComment(comment);
        LenLog.staticInfo("Comment-post", blogId.toString());
        return "redirect:/comments/" + blogId;
    }
}
