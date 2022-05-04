package com.len.library.library01.service;

import com.len.library.library01.dao.BookRepository;
import com.len.library.library01.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBookList(){
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
