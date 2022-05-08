package len.cloud02.blog.service;

import len.cloud02.common.entity.user.User;

public interface UserService {
    User checkUser(String username, String password);

    void addUser(User user);

    User getUser(Long id);
}
