<<<<<<< HEAD
package len.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注意：这里我们先导入Controller接口
public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图。模型装数据，视图负责调转到哪里
        ModelAndView modelAndView1 = new ModelAndView();

        //业务代码
        // 封装对象，放在ModelAndView中。Model
        modelAndView1.addObject("msg","HelloSpringMVC!");

        //视图跳转
        // 封装要跳转的视图，放在ModelAndView中
        modelAndView1.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        return modelAndView1;
    }

}
=======
package len.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注意：这里我们先导入Controller接口
public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图。模型装数据，视图负责调转到哪里
        ModelAndView modelAndView1 = new ModelAndView();

        //业务代码
        // 封装对象，放在ModelAndView中。Model
        modelAndView1.addObject("msg","HelloSpringMVC!");

        //视图跳转
        // 封装要跳转的视图，放在ModelAndView中
        modelAndView1.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        return modelAndView1;
    }

}
>>>>>>> 1da3f48 (first commit)
