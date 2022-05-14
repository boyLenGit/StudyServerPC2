package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.pojo.User;
import com.len.library.library01.service.BookService;
import com.len.library.library01.service.UserService;
import com.len.library.library01.util.LenLog;
import com.len.library.library01.util.LenPath;
import com.len.library.library01.util.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    // 用户注册
    // http://localhost:8081/user/sign_in_get
    @GetMapping("/sign_in")
    public String sign_in(Model model){
        model.addAttribute("user", new User());
        return "user/sign_in";
    }

    @PostMapping("/sign_in_post")
    public String signIn_post(@Valid User user, MultipartFile image1) throws IOException {
        String icon_path = "https://picsum.photos/50/50";
        if (image1!=null){
            icon_path = "/upload/user_icon/" + user.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String file_path_store = LenPath.getData() + icon_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
        }
        user.setUser_icon(icon_path);
        userService.addUser(user);
        return "redirect:/books";
    }

    // 用户登录
    @GetMapping("/sign_up")
    public String sign_up(){
        return "user/sign_up";
    }

    @PostMapping("/sign_up_post")
    public String sign_up_post(@RequestParam String name, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        LenLog.info("sign_up_post", name + " | " + password);
        User user = userService.checkUser(name, password);
        if (user==null){
            attributes.addFlashAttribute("message", "用户名或密码不正确");
            return "redirect:/user/sign_up";
        }else {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "redirect:/";
        }
    }

    @GetMapping("/sign_out")
    public String sign_out(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    // 借阅
    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable Integer id, RedirectAttributes attributes){
        Book book = bookService.getBookById(id);
        if (book.getRemain()>0){
            book.setRemain(book.getRemain()-1);
            attributes.addFlashAttribute("message_borrow", "书籍《 " + book.getName() + "》借阅成功！");
            return "redirect:/books";
        }else {
            attributes.addFlashAttribute("message_borrow", "书籍《 " + book.getName() + "》已经全被借走了！");
            return "redirect:/books";
        }
    }
}
