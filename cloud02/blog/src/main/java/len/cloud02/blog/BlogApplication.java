package len.cloud02.blog;

import len.cloud02.blog.util.base.LenLog;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BlogApplication.class, args);
//        // 打印所有bean的信息
//        int bean_num = applicationContext.getBeanDefinitionCount();
//        String[] bean_name = applicationContext.getBeanDefinitionNames();
//        for (String item: bean_name){
//            LenLog.staticInfo("main", item);
//        }
//        LenLog.staticInfo("main", String.valueOf(bean_num));
    }

}
