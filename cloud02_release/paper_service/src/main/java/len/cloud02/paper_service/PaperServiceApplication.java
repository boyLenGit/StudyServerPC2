package len.cloud02.paper_service;

import len.cloud02.paper_service.util.LenLog;
import len.cloud02.paper_service.util.LenPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EntityScan(basePackages = {"len.cloud02.common.entity"})
@SpringBootApplication
public class PaperServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperServiceApplication.class, args);
        LenLog.info2(PaperServiceApplication.class, "main", "Spring静态资源路径："+ LenPath.getData());
    }

}
