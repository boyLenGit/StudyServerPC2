package com.len.library.library01.service;

import com.len.library.library01.dao.UserRepository;
import com.len.library.library01.pojo.User;
import com.len.library.library01.util.LenLog;
import com.len.library.library01.util.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        LenLog.info("addUser", user.toString());
        user.setPassword(MD5Utils.code(user.getPassword()));
        userRepository.save(user);
    }

    public User checkUser(String name, String password){
        User user_sql = userRepository.findUserByNameAndPassword(name, MD5Utils.code(password));
        return user_sql;
    }

    public User getUserById(Integer id){
        return userRepository.getById(id);
    }

    public void updateUser(User user){
        User user_sql = getUserById(user.getId());
        BeanUtils.copyProperties(user, user_sql);
        userRepository.save(user);
    }
}
