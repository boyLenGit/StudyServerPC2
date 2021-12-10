package len.cloud01.artifact.service;

import len.cloud01.artifact.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
