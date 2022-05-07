package com.len.library.library01.dao;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository  extends JpaRepository<User, Long>, JpaSpecificationExecutor {

}
