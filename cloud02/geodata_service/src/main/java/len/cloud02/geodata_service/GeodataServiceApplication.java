package len.cloud02.geodata_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("len.cloud02.geodata_service.mapper")
@SpringBootApplication
public class GeodataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeodataServiceApplication.class, args);
    }

}
