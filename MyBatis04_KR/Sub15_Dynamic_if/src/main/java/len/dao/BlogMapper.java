package len.dao;

import java.util.List;
import java.util.Map;
import len.pojo.Blog;

public interface BlogMapper {

    void addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogchoose(Map map);

    void updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}
