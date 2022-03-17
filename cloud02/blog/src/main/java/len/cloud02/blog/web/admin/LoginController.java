package len.cloud02.blog.web.admin;

import len.cloud02.blog.po.User;
import len.cloud02.blog.service.UserService;
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

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession httpSession, RedirectAttributes attributes){
        logger.info("Len logger <Controller-login-init>|| username={}, password={}", username, password);
        User user = userService.checkUser(username, password);
        logger.info("Len logger <Controller-login-user>|| user={}", user);
        if (user != null){
            user.setPassword(null);
            httpSession.setAttribute("user", user);
            return "admin/admin_index";
        }else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/admin";
    }
}
