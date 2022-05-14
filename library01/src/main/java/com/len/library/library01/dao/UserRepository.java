package com.len.library.library01.dao;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<User, Integer>, JpaSpecificationExecutor {

    @Query("SELECT u FROM user u WHERE u.name=?1 AND u.password=?2")
    public User findUserByNameAndPassword(String name, String password);
}
