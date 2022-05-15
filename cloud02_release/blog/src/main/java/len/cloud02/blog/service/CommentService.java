package len.cloud02.blog.service;

import len.cloud02.blog.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    List<Comment> listCommentByBlogIdAndParentCommentNull(Long blogId);

    Comment saveComment(Comment comment);
}
