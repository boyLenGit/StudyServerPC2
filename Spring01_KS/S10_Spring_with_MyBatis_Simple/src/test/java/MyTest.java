import len.mapper.UserMapper;
import len.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MyTest {

    @Test
    public void selectAllUsers() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mapper.xml");
        UserMapper userMapper = context.getBean("userMapper_itself", UserMapper.class);
        for (User user : userMapper.selectAllUsers()){
            System.out.println(user);
        }

        System.out.println("GetUserById:"+userMapper.getUserById(1));
    }
}
