package len.cloud02.blog_service.mapper;

import len.cloud02.blog_service.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/19 00:01
 */
@Repository
public interface BlogMapper {
    Blog getBlogById(Long id);

    Blog getBlogLiteById(Long id);

    List<Blog> getBlogListByPage(Integer startIndex, Integer pageSize);

    List<Blog> getBlogLiteListByPage(Integer startIndex, Integer pageSize);

    Integer countBlogListForPage();

    void likeOrDislikeBlog(Long id, Integer adder);
}
