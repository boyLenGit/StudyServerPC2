package len.cloud02.blog.web;

import len.cloud02.blog.service.BlogService;
import len.cloud02.blog.service.UserService;
import len.cloud02.blog.util.base.LenLog;
import len.cloud02.blog.util.base.LenTime;
import len.cloud02.common.Util.LenPath;
import len.cloud02.common.entity.user.Blog;
import len.cloud02.common.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    private String register(Model model){
        model.addAttribute("user", new User());
        return "/user/register";
    }

    @PostMapping("/register_post")
    private String register_post(@Valid User user, MultipartFile image1) throws IOException {
        String icon_path = "https://picsum.photos/50/50";
        if (image1!=null){
            icon_path = "/Upload/user_icon/" + user.getUsername().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String file_path_store = LenPath.getData() + icon_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
        }
        user.setAvatar(icon_path);
        user.setCreateTime(new Date());
        userService.addUser(user);
        return "redirect:/";
    }

    // 浏览用户的文章列表
    @GetMapping("/articles")
    public String articles(@PageableDefault(size = 9, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model, HttpServletRequest request){
        User user_web = (User) request.getSession().getAttribute("user");
        LenLog.info2(this.getClass(), "articles", user_web.toString());
        User user_sql = userService.getUser(user_web.getId());
        LenLog.info2(this.getClass(), "articles", user_sql.toString());
        Page<Blog> blogPage = blogService.listBlogByUser(pageable, user_sql);
        LenLog.info2(this.getClass(), "articles", blogPage.toString());
        model.addAttribute("page", blogPage);
        return "/user/user_articles";
    }
}
