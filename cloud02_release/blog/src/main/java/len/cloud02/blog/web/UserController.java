package len.cloud02.blog.web;

import len.cloud02.blog.service.BlogService;
import len.cloud02.blog.service.UserService;
import len.cloud02.blog.pojo.Blog;
import len.cloud02.blog.pojo.User;
import len.cloud02.blog.util.LenLog;
import len.cloud02.blog.util.LenPath;
import len.cloud02.blog.util.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;

    // 用户注册
    @GetMapping("/register_get")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register_post")
    public String register_post(@Valid User user, MultipartFile image1, RedirectAttributes attributes) throws IOException {
        LenLog.info2(getClass(), "register_post", user.getUsername() + "|" + user.getPassword());
        // 监测用户是否重复
        User user_sql = userService.findUserByName(user.getUsername());
        if (user_sql!=null){
            attributes.addFlashAttribute("message", "用户名已存在！");
            return "redirect:/user/register_post";
        }
        // 正常保存
        String icon_path = "https://picsum.photos/50/50";
        if (image1!=null){
            icon_path = "/upload/user_icon/" + user.getUsername().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String file_path_store = LenPath.getData() + icon_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
            LenLog.info2(this.getClass(), "register_post", icon_path);
        }
        user.setAvatar(icon_path);
        user.setCreateTime(new Date());
        user.setType(0); // 设置为普通用户
        userService.addUser(user);
        return "redirect:/";
    }

    // 浏览用户的文章列表
    @GetMapping("/articles")
    public String articles(@PageableDefault(size = 9, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model, HttpServletRequest request){
        User user_web = (User) request.getSession().getAttribute("user");
        if (user_web==null){
            return "redirect:/user/login";
        }else {
            LenLog.info2(this.getClass(), "articles", user_web.getUsername());
            User user_sql = userService.getUser(user_web.getId());
            LenLog.info2(this.getClass(), "articles", user_sql.getUsername());
            Page<Blog> blogPage = blogService.listBlogByUser(pageable, user_sql);
            LenLog.info2(this.getClass(), "articles", String.valueOf(blogPage.getTotalPages()));
            model.addAttribute("page", blogPage);
            return "user/user_articles";
        }
    }

    // 用户登录
    @GetMapping("/login")
    public String login_get(Model model){
        return "user/user_login";
    }

    @PostMapping("/login_post")
    public String login_post(@Valid User user, RedirectAttributes redirectAttributes, HttpSession httpSession){
        LenLog.info2(getClass(), "login_post", user.getUsername() + "|" + user.getPassword());
        User user_sql = userService.checkUser(user.getUsername(), user.getPassword());
        if (user_sql!=null){
            user.setPassword(null);
            httpSession.setAttribute("user", user_sql);
//            return "user/user_articles";
            return "redirect:/";
        }else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/user/login";
        }
    }
}
