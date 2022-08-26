package len.cloud02.blog.test;

import len.cloud02.blog.error.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController01 {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test/error/500")
    public String test_error_500(){
        int i = 9 / 0;
        return "index";
    }

    @GetMapping("/test/error/custom_jump")
    public String test_error_custom_jump(){
        throw new NotFoundException("测试指定错误网页跳转");
    }

    @GetMapping("/test/aop/order/{id}/{name}")
    public String test_aop_order(@PathVariable Integer id, @PathVariable String name){
        logger.info("--------Function-------- || id={}, name={}", id, name);
//        System.out.println("--------Function-------- || id={}, name={}");
        return "index";
    }

    @GetMapping("/test/web/display/{html}")
    public String test_web_display(@PathVariable String html){
        logger.info("--------Function-------- || html={}", html);
//        System.out.println("--------Function-------- || id={}, name={}");
        return "admin/login";
    }

    @GetMapping("/test/web/display/admin_types_input")
    public String test_web_display__admin_types_input(){
        logger.info("--------Function-------- || html=admin_types_input");
//        System.out.println("--------Function-------- || id={}, name={}");
        return "admin_types_input";
    }

}
