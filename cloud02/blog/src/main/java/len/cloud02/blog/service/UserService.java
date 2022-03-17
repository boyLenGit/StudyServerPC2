package len.cloud02.blog.service;

import len.cloud02.blog.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
