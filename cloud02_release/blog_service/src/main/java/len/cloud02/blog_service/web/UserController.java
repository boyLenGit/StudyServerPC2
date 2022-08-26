package len.cloud02.blog_service.web;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.blog_service.entity.Blog;
import len.cloud02.blog_service.entity.User;
import len.cloud02.blog_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 11:05
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserByUsername")
    public User getUserByUsername(@RequestParam String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/getUserByUsernameAndPassword")
    public User getUserByUsernameAndPassword(@RequestParam String username, @RequestParam String password){
        return userService.getUserByUsernameAndPassword(username, password);
    }

    @PostMapping("/addUser")
    public JSONObject getUserByUsername(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        boolean bool = userService.addUser(user);
        jsonObject.put("msg", bool);
        return jsonObject;
    }

    @PostMapping("/addOrUpdateBlog")
    public JSONObject addOrUpdateBlog(@RequestBody Blog blog){
        JSONObject jsonObject = new JSONObject();
        Boolean isSaved = userService.addOrUpdateBlog(blog);
        jsonObject.put("msg", isSaved);
        return jsonObject;
    }

}
