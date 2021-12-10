<<<<<<< HEAD
import len.dao.BookMapper;
import len.pojo.Books;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import len.mybatis.BooksMyBatis;

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
}
=======
import len.dao.BookMapper;
import len.pojo.Books;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import len.mybatis.BooksMyBatis;

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
}
>>>>>>> 1da3f48 (first commit)
