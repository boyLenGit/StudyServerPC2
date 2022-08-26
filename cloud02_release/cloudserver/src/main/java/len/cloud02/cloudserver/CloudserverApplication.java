package len.cloud02.cloudserver;

import len.cloud02.cloudserver.service.BootService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("len.cloud02.cloudserver.mapper")
public class CloudserverApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CloudserverApplication.class, args);

        BootService bootService = applicationContext.getBean(BootService.class);
        bootService.syncRedis();
    }

}
