package len.cloud02.front.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Blog;
import len.cloud02.front.entity.Comment;
import len.cloud02.front.entity.Param;
import len.cloud02.front.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/27 23:08
 */
@Service
public class BlogCommentService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${boyLen_blogService_url}")
    private String blogServiceUrl;

    public List<Comment> getBlogCommentList(Long blogId){
        String url = blogServiceUrl + "/blog/comment/list";
        url += HttpClientUtils.paramsToUrl(new Param("blogId", blogId));
        JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        List<Comment> comments = jsonArray.toJavaList(Comment.class);
        for (int i1=0; i1<comments.size(); i1++){
            Comment comment = comments.get(i1);
            // 如果当前comment有父级
            if (comment.getParentId() != -1){
                Long parentCommentId = comment.getParentId();;
                for (int i2=0; i2< comments.size(); i2++){
                    Comment parentComment = comments.get(i2);
                    if (parentComment.getId().longValue() == parentCommentId.longValue()){
                        parentComment.getReplyComments().add(comment);
                        comments.remove(i1);
                        i1--;
                    }
                }
            }
        }
        return comments;
    }

    public boolean addBlogComment(Comment comment, Long blogUserId){
        String url = blogServiceUrl + "/blog/comment/add";
        // 初始化comment
        comment.setCreateTime(new Date());
        comment.setLikes(0L);
        if (blogUserId.longValue() == comment.getBlogId().longValue()){
            comment.setIsAuthor(1);
        }else {
            comment.setIsAuthor(0);
        }

        JSONObject res = restTemplate.postForObject(url, comment, JSONObject.class);
        if (res != null){
            System.out.println(res.get("msg"));
        }
        return true;
    }
}
