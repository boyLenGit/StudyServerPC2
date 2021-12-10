<<<<<<< HEAD
import len.pojo.Hello_have_param_A;
import len.pojo.Hello_have_param_B;
import len.pojo.Hello_have_param_C;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02_have_param {

    @Test
    public void HaveParamA(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello_have_param_A hello = (Hello_have_param_A) context.getBean("bean_hava_param_A");
        hello.setStr("@TEST测试部；");
        System.out.println(hello.toString());
    }

    @Test
    public void HaveParamB(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello_have_param_B hello = (Hello_have_param_B) context.getBean("bean_hava_param_B");
        hello.setStr("@TEST测试部；");
        System.out.println(hello.toString());
    }

    @Test
    public void HaveParamC(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello_have_param_C hello = (Hello_have_param_C) context.getBean("bean_hava_param_C");
        hello.setStr("@TEST测试部；");
        System.out.println(hello.toString());
    }
}
=======
import len.pojo.Hello_have_param_A;
import len.pojo.Hello_have_param_B;
import len.pojo.Hello_have_param_C;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02_have_param {

    @Test
    public void HaveParamA(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello_have_param_A hello = (Hello_have_param_A) context.getBean("bean_hava_param_A");
        hello.setStr("@TEST测试部；");
        System.out.println(hello.toString());
    }

    @Test
    public void HaveParamB(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello_have_param_B hello = (Hello_have_param_B) context.getBean("bean_hava_param_B");
        hello.setStr("@TEST测试部；");
        System.out.println(hello.toString());
    }

    @Test
    public void HaveParamC(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello_have_param_C hello = (Hello_have_param_C) context.getBean("bean_hava_param_C");
        hello.setStr("@TEST测试部；");
        System.out.println(hello.toString());
    }
}
>>>>>>> 1da3f48 (first commit)
