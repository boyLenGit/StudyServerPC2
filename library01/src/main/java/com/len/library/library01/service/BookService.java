package com.len.library.library01.service;

import com.len.library.library01.dao.BookRepository;
import com.len.library.library01.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

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

    public Book modifyBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(Long.valueOf(id));
    }
}
