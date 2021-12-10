<<<<<<< HEAD
import len.dao.BookMapper;
import len.mybatis.BooksMyBatis;
import len.pojo.Books;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMyBatis {
    @Test
    public void T01_getUserByID(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = BooksMyBatis.getSqlSession();
        BookMapper bookMapper1 = sqlSession1.getMapper(BookMapper.class);

        Books books1 = bookMapper1.queryBookById(2);
        System.out.println(books1);
        // 关闭SQLSession
        sqlSession1.close();
    }
    @Test
    public void T(){
        float a = 3.14f;
    }
}
=======
import len.dao.BookMapper;
import len.mybatis.BooksMyBatis;
import len.pojo.Books;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMyBatis {
    @Test
    public void T01_getUserByID(){
        // 获得SqlSession对象
        SqlSession sqlSession1 = BooksMyBatis.getSqlSession();
        BookMapper bookMapper1 = sqlSession1.getMapper(BookMapper.class);

        Books books1 = bookMapper1.queryBookById(2);
        System.out.println(books1);
        // 关闭SQLSession
        sqlSession1.close();
    }
    @Test
    public void T(){
        float a = 3.14f;
    }
}
>>>>>>> 1da3f48 (first commit)
