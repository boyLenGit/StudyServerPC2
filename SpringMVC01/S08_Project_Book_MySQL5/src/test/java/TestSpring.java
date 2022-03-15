<<<<<<< HEAD
import len.pojo.Books;
import len.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    @Test
    public void testBeanSQL(){
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 调用的是BookServiceImpl，但是类型是BookService，因为是BookService提供的接口
        BookService bookServiceImpl = (BookService) context1.getBean("BookServiceImpl");
        List<Books> book1 = bookServiceImpl.queryAllBooks();
        for (Books book:book1){
            System.out.println(book);
        }
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)applicationContext.getBean("BookServiceImpl");
        List<Books> books = bookService.queryAllBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }

}
=======
import len.pojo.Books;
import len.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    @Test
    public void testBeanSQL(){
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 调用的是BookServiceImpl，但是类型是BookService，因为是BookService提供的接口
        BookService bookServiceImpl = (BookService) context1.getBean("BookServiceImpl");
        List<Books> book1 = bookServiceImpl.queryAllBooks();
        for (Books book:book1){
            System.out.println(book);
        }
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)applicationContext.getBean("BookServiceImpl");
        List<Books> books = bookService.queryAllBooks();
        for (Books book : books) {
            System.out.println(book);
        }
    }

}
>>>>>>> 1da3f48 (first commit)
