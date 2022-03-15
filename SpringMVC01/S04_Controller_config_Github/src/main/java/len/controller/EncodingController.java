<<<<<<< HEAD
package len.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EncodingController {
    //过滤器解决乱码
    @RequestMapping(value = "/e/t1", method = RequestMethod.POST)
    public String test1(String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test";
    }
}
=======
package len.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EncodingController {
    //过滤器解决乱码
    @RequestMapping(value = "/e/t1", method = RequestMethod.POST)
    public String test1(String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg",name);
        return "test";
    }
}
>>>>>>> 1da3f48 (first commit)
