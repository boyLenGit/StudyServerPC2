package len.cloud01.artifact.service;

import len.cloud01.artifact.po.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    List<Comment> listCommentByBlogIdAndParentCommentNull(Long blogId);

    Comment saveComment(Comment comment);
}
