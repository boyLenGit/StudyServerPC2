package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBookListController(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                        Model model)
    {
        Page<Book> books = bookService.getBookList(pageable);
        System.out.println("LenTest: " + books);
        model.addAttribute("books", books);
        return "book_list";
    }
}
