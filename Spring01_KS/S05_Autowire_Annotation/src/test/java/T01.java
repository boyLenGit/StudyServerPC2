<<<<<<< HEAD
import len.pojo.People_At_Autowired;
import len.pojo.People_At_Resource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People_At_Autowired peopleAtAutowired = (People_At_Autowired) context.getBean("people_at_autowired");
        System.out.println("测试注解开发@Autowired");
        peopleAtAutowired.getCat().shout();
        peopleAtAutowired.getDog().shout();

        People_At_Resource peopleAtResourced = (People_At_Resource) context.getBean("people_at_resource");
        System.out.println("测试注解开发@Resource");
        peopleAtResourced.getCat().shout();
        peopleAtResourced.getDog().shout();
    }
}
=======
import len.pojo.People_At_Autowired;
import len.pojo.People_At_Resource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People_At_Autowired peopleAtAutowired = (People_At_Autowired) context.getBean("people_at_autowired");
        System.out.println("测试注解开发@Autowired");
        peopleAtAutowired.getCat().shout();
        peopleAtAutowired.getDog().shout();

        People_At_Resource peopleAtResourced = (People_At_Resource) context.getBean("people_at_resource");
        System.out.println("测试注解开发@Resource");
        peopleAtResourced.getCat().shout();
        peopleAtResourced.getDog().shout();
    }
}
>>>>>>> 1da3f48 (first commit)
