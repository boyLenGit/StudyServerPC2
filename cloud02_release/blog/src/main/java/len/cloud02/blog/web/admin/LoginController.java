package len.cloud02.blog.web.admin;

import len.cloud02.blog.service.UserService;
import len.cloud02.blog.pojo.User;
import len.cloud02.blog.util.LenLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")  // ！要进入登录页面，不要写".../admin/login"！应该写".../admin"，会通过方法loginPage跳转到login页面
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/admin_index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession httpSession, RedirectAttributes attributes){
        LenLog.info2(getClass(), "login", username + "|" + password);
        User user = userService.checkUser(username, password);
        if (user != null){
            LenLog.info2(getClass(), "login", "查询的用户为不空："+ user.getUsername());
            if (user.getType()==0){
                attributes.addFlashAttribute("message", "不是管理员账号！已报告给管理员！");
                return "redirect:/admin";
            }else {  // 是管理员用户或者su用户
                user.setPassword(null);
                httpSession.setAttribute("user", user);
                return "admin/admin_index";
            }
        }else {
            LenLog.info2(getClass(), "login", "查询的用户为空");
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/";
    }
}
