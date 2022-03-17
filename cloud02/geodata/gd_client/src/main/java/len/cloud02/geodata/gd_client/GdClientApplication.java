package len.cloud02.geodata.gd_client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("len.cloud02.geodata.gd_client.mapper")
@SpringBootApplication
public class GdClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdClientApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate loadBalanced(){
        return new RestTemplate();
    }
}
