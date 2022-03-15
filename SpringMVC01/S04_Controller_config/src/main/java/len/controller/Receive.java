<<<<<<< HEAD
package len.controller;

import len.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/receive")
public class Receive {

    // http://localhost:8080/S04_Controller_config_war_exploded/receive/t1?username=boyLen
    // @RequestParam("username") 指定网页的数据Key值，此时String name已经失效，因此username=boylen可以，但是name=boylen不可以
    @RequestMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        // 1.接收前端参数
        System.out.println("接收到前端的参数为：" + name);
        // 2.将返回的结果传递给前端，Model
        model.addAttribute("msg",name);
        return "test";
    }

    // 前端接收的是一个对象：id，name，age
    /*
    1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2.假设传递的是一个对象user，匹配user对象中的字段名，如果名字一直则ok，否则匹配不到
     */
    // 网址：http://localhost:8080/S04_Controller_config_war_exploded/receive/t2?id=1&name=boylen&age=19
    @GetMapping("/t2")
    public String test2(User user) {
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap modelMap) {
        //System.out.println(user);
        return "test";
    }


}
=======
package len.controller;

import len.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/receive")
public class Receive {

    // http://localhost:8080/S04_Controller_config_war_exploded/receive/t1?username=boyLen
    // @RequestParam("username") 指定网页的数据Key值，此时String name已经失效，因此username=boylen可以，但是name=boylen不可以
    @RequestMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        // 1.接收前端参数
        System.out.println("接收到前端的参数为：" + name);
        // 2.将返回的结果传递给前端，Model
        model.addAttribute("msg",name);
        return "test";
    }

    // 前端接收的是一个对象：id，name，age
    /*
    1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2.假设传递的是一个对象user，匹配user对象中的字段名，如果名字一直则ok，否则匹配不到
     */
    // 网址：http://localhost:8080/S04_Controller_config_war_exploded/receive/t2?id=1&name=boylen&age=19
    @GetMapping("/t2")
    public String test2(User user) {
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap modelMap) {
        //System.out.println(user);
        return "test";
    }


}
>>>>>>> 1da3f48 (first commit)
