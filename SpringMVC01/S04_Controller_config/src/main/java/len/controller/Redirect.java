<<<<<<< HEAD
package len.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Redirect {
    @RequestMapping("/t_redirect")
    public String test(Model model) {

        model.addAttribute("msg","ModelTest1");
        //转发,默认（不配置视图解析器）
        //return "forward:/WEB-INF/jsp/test.jsp";
        //重定向（不配置视图解析器）
        //return "redirect:/index.jsp";
        //转发forward,默认（配置视图解析器）
        //return "test";
        //重定向（配置视图解析器）
        return "redirect:/index.jsp";
    }
}
=======
package len.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Redirect {
    @RequestMapping("/t_redirect")
    public String test(Model model) {

        model.addAttribute("msg","ModelTest1");
        //转发,默认（不配置视图解析器）
        //return "forward:/WEB-INF/jsp/test.jsp";
        //重定向（不配置视图解析器）
        //return "redirect:/index.jsp";
        //转发forward,默认（配置视图解析器）
        //return "test";
        //重定向（配置视图解析器）
        return "redirect:/index.jsp";
    }
}
>>>>>>> 1da3f48 (first commit)
