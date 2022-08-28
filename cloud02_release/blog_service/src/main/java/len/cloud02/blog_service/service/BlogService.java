package len.cloud02.blog_service.service;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Blog;
import len.cloud02.blog_service.mapper.BlogMapper;
import len.cloud02.blog_service.mapper.UserMapper;
import len.cloud02.blog_service.utils.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/19 13:45
 */
@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ThreadPoolService threadPoolService;

    public Blog getBlogById(Long id){
        Blog blog = blogMapper.getBlogById(id);
        blog.setViews(blog.getViews()+1);
        // 线程池更新blog
        threadPoolService.execute(() -> {
            userMapper.updateBlog(blog);
        });
        return blog;
    }

    public void likeOrDislikeBlog(Long id, Integer adder){
        blogMapper.likeOrDislikeBlog(id, adder);
    }

    public JSONObject getBlogLiteListByPage(Integer pageNum, Integer pageSize){
        Integer startIndex = pageNum * pageSize;
        // 查询
        List<Blog> blogList = blogMapper.getBlogLiteListByPage(startIndex, pageSize);
        Integer total = blogMapper.countBlogListForPage();

        // 处理结果
        JSONObject result = new JSONObject();
        result.put("list", blogList);
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        result.put("pages", (total / pageSize) + 1);
        result.put("size", blogList.size());
        result.put("total", total);
        return result;
    }

    public JSONObject getBlogListByPage(Integer pageNum, Integer pageSize){
        Integer startIndex = pageNum * pageSize;
        // 查询
        List<Blog> blogList = blogMapper.getBlogListByPage(startIndex, pageSize);
        Integer total = blogMapper.countBlogListForPage();

        // 处理结果
        JSONObject result = new JSONObject();
        result.put("list", blogList);
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        result.put("pages", (total / pageSize) + 1);
        result.put("size", blogList.size());
        result.put("total", total);
        return result;
    }


}
