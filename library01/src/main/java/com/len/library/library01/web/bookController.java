package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBookListController(Model model){
        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "book_list";
    }
}
