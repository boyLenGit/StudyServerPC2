package len.cloud02.blog_service.mapper;

import len.cloud02.blog_service.entity.Blog;
import len.cloud02.blog_service.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 10:59
 */
@Repository
public interface UserMapper {
    User getUserByUsername(String username);

    User getUserByUsernameAndPassword(String username, String password);

    Boolean addUser(User user);

    Boolean addBlog(Blog blog);

    Boolean updateBlog(Blog blog);
}
