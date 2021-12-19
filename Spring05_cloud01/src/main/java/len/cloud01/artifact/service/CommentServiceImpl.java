package len.cloud01.artifact.service;

import len.cloud01.artifact.dao.CommentRepository;
import len.cloud01.artifact.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        // 作用：用于返回博客的评论，并且按照评论时间倒序排序
        // 旧版：Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        return commentRepository.findByBlogId(blogId, sort);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return null;
    }
}
