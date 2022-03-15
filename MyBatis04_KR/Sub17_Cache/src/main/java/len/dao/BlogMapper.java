<<<<<<< HEAD
package len.dao;

import len.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    void addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogchoose(Map map);

    void updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);

    List<Blog> queryBlogForeach_list(List map);
}
=======
package len.dao;

import len.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    void addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogchoose(Map map);

    void updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);

    List<Blog> queryBlogForeach_list(List map);
}
>>>>>>> 1da3f48 (first commit)
