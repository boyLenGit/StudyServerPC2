import len.service.BookService;
import len.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void testBeanSQL(){
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 调用的是BookServiceImpl，但是类型是BookService，因为是BookService提供的接口
        BookService bookServiceImpl = (BookService) context1.getBean("BookServiceImpl");

    }
}
