package len.cloud01.artifact.service;

import len.cloud01.artifact.dao.CommentRepository;
import len.cloud01.artifact.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
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

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId != -1){  // 如果当前的comment不是父级，则给这个comment设置父级。
            // ⬇ comment中带有父级comment的id，但是不含有父级comment的其他属性（如comment的内容），因此这里是为了将父级comment整个都给当前comment，即实例化
            comment.setParentComment(commentRepository.getById(parentCommentId));
        }else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }
}
