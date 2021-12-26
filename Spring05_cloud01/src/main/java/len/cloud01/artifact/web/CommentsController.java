package len.cloud01.artifact.web;

import len.cloud01.artifact.po.Blog;
import len.cloud01.artifact.po.Comment;
import len.cloud01.artifact.po.User;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    // ↓ 这个comment.avatar位于/resources/application-dev.yml
    @Value("${comment.avatar}")
    private String avatar;

    // Debug：http://localhost:8080/comments/34
    @GetMapping("/comments/{blogId}")
    public String Comments(@PathVariable Long blogId, Model model){
        List<Comment> commentList = commentService.listCommentByBlogIdAndParentCommentNull(blogId);
        model.addAttribute("comments", commentList);
        return "article :: commentList";
    }

    // 网页提交评论内容
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId = comment.getBlog().getId();
        // 用于实例化Comment对象中的Blog。
        // 【方法】到底哪些对象需要在这里单独实例化？→查看web端与Comment对象，看看哪些变量传递进去了，哪些没传递进去，没传递进去的就是需要实例化/填充的，否则Comment部分属性为空。
        comment.setBlog(blogService.getBlog(blogId));
        // ↓ 管理员身份验证
        Blog blog = (Blog) session.getAttribute("blog");
        User user = blog.getUser();
        LenLog.staticInfo("Comment-post", user.getUsername() + "||" + comment.getNickname());
        if (user.getUsername().equals(comment.getNickname())){
            // 表明评论用户就是博客作者
            comment.setAvatar(avatar);
            comment.setAdminComment(true);  // 设置comment用户为作者
        }else {
            comment.setAvatar(avatar);
            comment.setAdminComment(false);
        }
        // ↓ 保存comment
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}

// 如果想要更改评论的时间倒序/正序，只需要修改Impl中的Sort即可，删除sort中的Desc，只保留'commentTime'