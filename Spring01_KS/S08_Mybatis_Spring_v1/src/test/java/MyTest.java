import len.mapper.UserMapper;
import len.pojo.User;
import len.ibatis.io.Resources;
import len.ibatis.session.SqlSession;
import len.ibatis.session.SqlSessionFactory;
import len.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyTest {

    @Test
    public void selectAllUsers() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.selectAllUsers();
        users.forEach(System.out::println);

    }
}
