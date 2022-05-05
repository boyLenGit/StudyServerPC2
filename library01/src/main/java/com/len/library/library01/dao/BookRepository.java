package com.len.library.library01.dao;


import com.len.library.library01.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor {
    @Modifying  // update、delete需要加这个
    @Query("DELETE FROM book b WHERE b.id=?1")
    void deleteByIntId(int id);
}
