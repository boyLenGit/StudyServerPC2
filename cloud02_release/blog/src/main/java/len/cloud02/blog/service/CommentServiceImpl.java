package len.cloud02.blog.service;

import len.cloud02.blog.dao.CommentRepository;
import len.cloud02.blog.pojo.Comment;
import len.cloud02.blog.util.LenLog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        LenLog.staticInfo("listCommentByBlogId 1", blogId.toString());
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        LenLog.staticInfo("listCommentByBlogId 2", sort.toString());
        List<Comment> comments = commentRepository.findByBlogId(blogId, sort);
        LenLog.staticInfo("listCommentByBlogId 3", Integer.toString(comments.size()));
        return comments;
    }

    @Override
    public List<Comment> listCommentByBlogIdAndParentCommentNull(Long blogId) {
        // 作用：用于返回博客的评论，并且按照评论时间倒序排序
        // 旧版：Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId, sort);
        return eachComment(comments);
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId != -1){  // 如果当前的comment不是父级，则给这个comment设置父级。
            // ⬇ comment中带有父级comment的id，但是不含有父级comment的其他属性（如comment的内容），因此这里是为了将父级comment整个都给当前comment，即实例化
            comment.setParentComment(commentRepository.getOne(parentCommentId));
        }else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments) {
        // 用于复制一个List<Comment>副本出来，没有别的作用
        List<Comment> commentsView = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    /**
     *
     * @param comments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Comment> comments) {

        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getReplyComments();
            for(Comment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            comment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param comment 被迭代的对象
     * @return
     */
    private void recursively(Comment comment) {
        tempReplys.add(comment);//顶节点添加到临时存放集合
        if (comment.getReplyComments().size()>0) {
            List<Comment> replys = comment.getReplyComments();
            for (Comment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }
}
