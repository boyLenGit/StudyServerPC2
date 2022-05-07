package com.len.library.library01.web;

import com.len.library.library01.pojo.User;
import com.len.library.library01.service.UserService;
import com.len.library.library01.util.LenPath;
import com.len.library.library01.util.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;

    // http://localhost:8081/user/sign_in_get
    @GetMapping("/sign_in_get")
    public String signIn_get(Model model){
        model.addAttribute("user", new User());
        return "user/sign_in";
    }

    @PostMapping("/sign_in_post")
    public String signIn_post(User user, MultipartFile image1) throws IOException {
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
        return "redirect:/";
    }
}
