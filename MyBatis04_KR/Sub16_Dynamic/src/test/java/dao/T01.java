<<<<<<< HEAD
package dao;

import len.dao.BlogMapper;
import len.pojo.Blog;
import len.mybatis.IDUtiles;
import len.mybatis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class T01 {

    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_author("houdongun");
        blog.setObj_createTime(new Date());
        blog.setObj_views(999);
        blog.setObj_title("first");

        blogMapper.addBlog(blog);

        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_title("second");
        blogMapper.addBlog(blog);

        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_title("third");
        blogMapper.addBlog(blog);

        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_title("forth");
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        map.put("Obj_title", "first");
        // map.put("author", "houdongun");
        // map.put("views", 999);

        List<Blog> list = blogMapper.queryBlogIF(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    // 用于测试Mapper中的set标签
    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        map.put("Obj_title", "second23");
        // map.put("author", "houdongun3");
        map.put("Obj_id", "bd4f2a83c3b843ab925dcd4d9aa6fbeb");

        blogMapper.updateBlog(map);

        sqlSession.close();

    }

    // 用于测试Mapper中的foreach标签
    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        map.put("list_id",list1);

        List<Blog> list = blogMapper.queryBlogForeach(map);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    // 用于测试Mapper中的foreach标签
    @Test
    public void queryBlogForeach_list(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);

        List<Blog> list = blogMapper.queryBlogForeach_list(list1);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
=======
package dao;

import len.dao.BlogMapper;
import len.pojo.Blog;
import len.mybatis.IDUtiles;
import len.mybatis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * [黑马版MyBatis示例代码]
 *      ·与狂人java的区别：Obj02多了个toString()方法，从而在输出内容上有所区别
 */

public class T01 {

    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_author("houdongun");
        blog.setObj_createTime(new Date());
        blog.setObj_views(999);
        blog.setObj_title("first");

        blogMapper.addBlog(blog);

        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_title("second");
        blogMapper.addBlog(blog);

        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_title("third");
        blogMapper.addBlog(blog);

        blog.setObj_id(IDUtiles.Len_getId());
        blog.setObj_title("forth");
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        map.put("Obj_title", "first");
        // map.put("author", "houdongun");
        // map.put("views", 999);

        List<Blog> list = blogMapper.queryBlogIF(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    // 用于测试Mapper中的set标签
    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        map.put("Obj_title", "second23");
        // map.put("author", "houdongun3");
        map.put("Obj_id", "bd4f2a83c3b843ab925dcd4d9aa6fbeb");

        blogMapper.updateBlog(map);

        sqlSession.close();

    }

    // 用于测试Mapper中的foreach标签
    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        map.put("list_id",list1);

        List<Blog> list = blogMapper.queryBlogForeach(map);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    // 用于测试Mapper中的foreach标签
    @Test
    public void queryBlogForeach_list(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);

        List<Blog> list = blogMapper.queryBlogForeach_list(list1);

        for (Blog blog : list) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
>>>>>>> 1da3f48 (first commit)
