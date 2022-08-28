package len.cloud02.blog_service.mapper;

import len.cloud02.blog_service.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 22:57
 */
@Repository
public interface BlogCommentMapper {
    void addComment(Comment comment);

    List<Comment> getBlogCommentList(Long blogId);
}
