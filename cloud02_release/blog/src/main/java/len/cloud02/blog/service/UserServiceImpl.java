package len.cloud02.blog.service;

import len.cloud02.blog.dao.UserRepository;
import len.cloud02.blog.util.MD5Utils;
import len.cloud02.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password){
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(MD5Utils.code(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
