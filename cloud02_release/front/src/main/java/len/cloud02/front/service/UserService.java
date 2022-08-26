package len.cloud02.front.service;

import com.alibaba.fastjson.JSONObject;
import len.cloud02.front.entity.Blog;
import len.cloud02.front.entity.Param;
import len.cloud02.front.entity.User;
import len.cloud02.front.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/21 11:56
 */
@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${boyLen_blogService_url}")
    private String blogServiceUrl;

    public User checkUser(String username, String password){
        String url = blogServiceUrl + "/user/getUserByUsernameAndPassword";
        url += HttpClientUtils.paramsToUrl(new Param("username", username), new Param("password", password));
        User user = restTemplate.getForObject(url, User.class);
        if (user != null){
            user.setPassword("");
        }
        return user;
    }

    public User getUserByUsername(String username){
        String url = blogServiceUrl + "/user/getUserByUsername";
        url += HttpClientUtils.paramsToUrl(new Param("username", username));
        User user = restTemplate.getForObject(url, User.class);
        if (user != null){
            user.setPassword("");
        }
        return user;
    }

    public Boolean addUser(User user){
        String url = blogServiceUrl + "/user/addUser";
        HttpHeaders headers = new HttpHeaders();
        JSONObject res = restTemplate.postForObject(url, user, JSONObject.class);
        if (res != null){
            System.out.println(res.get("msg"));
        }
        return true;
    }

    public Boolean addOrUpdateBlog(Blog blog){
        String url = blogServiceUrl + "/user/addOrUpdateBlog";
        JSONObject res = restTemplate.postForObject(url, blog, JSONObject.class);
        if (res != null){
            System.out.println(res.get("msg"));
        }
        return true;
    }
}
