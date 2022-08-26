package len.cloud02.front.web;

import len.cloud02.front.entity.Blog;
import len.cloud02.front.entity.Type;
import len.cloud02.front.entity.User;
import len.cloud02.front.service.BlogService;
import len.cloud02.front.service.TypeService;
import len.cloud02.front.service.UserService;
import len.cloud02.front.utils.LenLog;
import len.cloud02.front.utils.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 11:56
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Value("${boyLen_data_path}")
    private String DATA_PATH;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/loginPost")
    public String loginPost(@RequestParam String username, @RequestParam String password,
                            RedirectAttributes redirectAttributes, HttpSession httpSession) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            httpSession.setAttribute("user", user);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误！");
            return "redirect:/user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/registerPost")
    public String registerPost(@RequestParam String username, @RequestParam String nickname, @RequestParam String password,
                               @RequestParam String email, MultipartFile image1, RedirectAttributes attributes, HttpSession httpSession) throws IOException {
        // 监测用户是否重复
        User user_sql = userService.getUserByUsername(username);
        if (user_sql!=null){
            attributes.addFlashAttribute("message", "用户名已存在！");
            return "redirect:/user/register_post";
        }
        // 正常保存
        User user = new User(username, nickname, password, email);
        // 保存头像
        String icon_path = "/image/userAvatarHaveNotAvatar.jpg";
        if (image1!=null){
            icon_path = "/upload/user_icon/" + user.getUsername().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String file_path_store = DATA_PATH + icon_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
            LenLog.info2(this.getClass(), "register_post", icon_path);
        }
        user.setAvatar(icon_path);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setType(0);  // 设置为普通用户
        userService.addUser(user);
        // 加入用户session
        httpSession.setAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/addBlog")
    public String addBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "user/addBlog";
    }

    @PostMapping("/addOrUpdateBlogPost")
    public String addOrUpdateBlogPost(Model model, Blog blog, RedirectAttributes redirectAttributes, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        blog.setUser(user);
        // 设置Type
        List<Type> typeList = typeService.getTypeList();
        for (Object object: typeList){
            Type item = (Type) object;
            if (item.getId().longValue() == blog.getTypeId().longValue()){
                blog.setTypeName(item.getName());
            }
        }

        Boolean isSaved = userService.addOrUpdateBlog(blog);
        if (!isSaved){
            redirectAttributes.addFlashAttribute("message", "操作失败");
            redirectAttributes.addFlashAttribute("blog", blog);
            return "redirect:/user/addBlog";
        }else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
            return "redirect:/";
        }
        // TODO 应该返回到博客详情页面
    }

    @PostMapping("/type.data")
    public String getTypeList(Model model){
        List<Type> typeList = typeService.getTypeList();
        model.addAttribute("types", typeList);
        return "user/addBlog :: typeList";
    }
}
