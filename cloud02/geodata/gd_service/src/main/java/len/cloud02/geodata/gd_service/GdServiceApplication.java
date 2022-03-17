package len.cloud02.geodata.gd_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("len.cloud02.geodata.gd_service.mapper")
public class GdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdServiceApplication.class, args);
    }

}
