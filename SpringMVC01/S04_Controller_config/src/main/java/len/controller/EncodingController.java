<<<<<<< HEAD
package len.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {
    //过滤器解决乱码
    @RequestMapping("/e/t1")
    public String test1(String name, Model model) {
        System.out.println("Result: " + (name).toString());
        model.addAttribute("msg",name);
        return "test";
    }
}
=======
package len.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {
    //过滤器解决乱码
    @RequestMapping("/e/t1")
    public String test1(String name, Model model) {
        System.out.println("Result: " + (name).toString());
        model.addAttribute("msg",name);
        return "test";
    }
}
>>>>>>> 1da3f48 (first commit)
