package com.len.library.library01.service;

import com.len.library.library01.dao.BookRepository;
import com.len.library.library01.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Integer id){
        return bookRepository.getByIntId(id);
    }

    public Page<Book> getBookList(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        return books;
    }

    public void addBook(Book book){
        if (book.getId()==null){
            book.setView_time(0);
        }
        bookRepository.save(book);
    }

    @Transactional  // JPA要求，没有事务支持（即没有给方法加@Transactional），不能执行更新和删除操作，会报错”Executing an update/delete query“
    public Book modifyBook(Book book){
        return bookRepository.save(book);
    }

    @Transactional  // JPA要求，没有事务支持（即没有给方法加@Transactional），不能执行更新和删除操作，会报错”Executing an update/delete query“
    public void deleteBook(Integer id){
        bookRepository.deleteByIntId(id);
    }
}
