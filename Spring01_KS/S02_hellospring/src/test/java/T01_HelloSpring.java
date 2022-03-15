<<<<<<< HEAD
import len.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01_HelloSpring {
    public static void main(String[] args){
        // 获得Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // getBean中的值要与bean id="bean_hello"一致，表示让Spring生成该对象
        Hello hello = (Hello) context.getBean("bean_hello");
        System.out.println(hello.toString());
    }
}

=======
import len.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01_HelloSpring {
    public static void main(String[] args){
        // 获得Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // getBean中的值要与bean id="bean_hello"一致，表示让Spring生成该对象
        Hello hello = (Hello) context.getBean("bean_hello");
        System.out.println(hello.toString());
    }
}

>>>>>>> 1da3f48 (first commit)
