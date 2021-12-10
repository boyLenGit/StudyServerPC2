<<<<<<< HEAD
import len.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people1 = (People) context.getBean("people");
        System.out.println("常规测试");
        people1.getCat().shout();
        people1.getDog().shout();

        People people2 = (People) context.getBean("people_Autowired_byName");
        System.out.println("测试byName");
        people2.getCat().shout();
        people2.getDog().shout();

        People people3 = (People) context.getBean("people_Autowired_byType");
        System.out.println("测试byType");
        people3.getCat().shout();
        people3.getDog().shout();
    }
}
=======
import len.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people1 = (People) context.getBean("people");
        System.out.println("常规测试");
        people1.getCat().shout();
        people1.getDog().shout();

        People people2 = (People) context.getBean("people_Autowired_byName");
        System.out.println("测试byName");
        people2.getCat().shout();
        people2.getDog().shout();

        People people3 = (People) context.getBean("people_Autowired_byType");
        System.out.println("测试byType");
        people3.getCat().shout();
        people3.getDog().shout();
    }
}
>>>>>>> 1da3f48 (first commit)
