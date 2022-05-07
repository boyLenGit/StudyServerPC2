package com.len.library.library01.service;

import com.len.library.library01.dao.UserRepository;
import com.len.library.library01.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }
}
