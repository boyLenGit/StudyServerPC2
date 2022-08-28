package len.cloud02.blog_service.service;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Blog;
import len.cloud02.blog_service.entity.Comment;
import len.cloud02.blog_service.mapper.BlogCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 23:02
 */
@Service
public class BlogCommentService {
    @Autowired
    private BlogCommentMapper blogCommentMapper;

    public JSONObject getBlogCommentList(Long blogId){
        // 查询
        List<Comment> blogCommentList = blogCommentMapper.getBlogCommentList(blogId);

        // 处理结果
        JSONObject result = new JSONObject();
        result.put("list", blogCommentList);
        return result;
    }

    public JSONObject addBlogComment(Comment comment){
        // 查询
        blogCommentMapper.addComment(comment);

        // 处理结果
        JSONObject result = new JSONObject();
        result.put("msg", "success");
        return result;
    }
}
