package len.cloud02.blog_service.service;

import len.cloud02.blog_service.entity.Blog;
import len.cloud02.blog_service.entity.User;
import len.cloud02.blog_service.mapper.BlogMapper;
import len.cloud02.blog_service.mapper.UserMapper;
import len.cloud02.blog_service.utils.LenBeanUtils;
import len.cloud02.blog_service.utils.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 11:04
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;

    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }

    public User getUserByUsernameAndPassword(String username, String password){
        User user = userMapper.getUserByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    public boolean addUser(User user){
        user.setPassword(MD5Utils.code(user.getPassword()));
        return userMapper.addUser(user);
    }

    public void addBlog(Blog blog){
        userMapper.addBlog(blog);
        Blog blogById = blogMapper.getBlogById(blog.getId());
    }

    public Boolean addOrUpdateBlog(Blog blog){
        Boolean isSaved;
        // add逻辑
        if (blog.getId() == null){
            blog.setViews(0L);
            blog.setLikes(0L);
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            isSaved = userMapper.addBlog(blog);
        }
        // update逻辑
        else {
            Blog blogSql = blogMapper.getBlogLiteById(blog.getId());
            BeanUtils.copyProperties(blog, blogSql, LenBeanUtils.getNullPropertyNames(blog));
            blogSql.setUpdateTime(new Date());
            isSaved = userMapper.updateBlog(blogSql);
        }
        return isSaved;
    }
}
