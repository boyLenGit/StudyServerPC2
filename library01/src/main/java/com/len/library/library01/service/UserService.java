package com.len.library.library01.service;

import com.len.library.library01.dao.UserRepository;
import com.len.library.library01.pojo.User;
import com.len.library.library01.util.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        LenLog.info("addUser", user.toString());
        userRepository.save(user);
    }
}
