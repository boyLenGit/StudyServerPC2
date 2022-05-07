package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import com.len.library.library01.util.LenFile;
import com.len.library.library01.util.LenLog;
import com.len.library.library01.util.LenPath;
import com.len.library.library01.util.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class bookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBookListController(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                        Model model)
    {
        Page<Book> books = bookService.getBookList(pageable);  // 拿到Book列表，从数据库里拿
        System.out.println("LenTest: " + books);
        model.addAttribute("books", books);  // 把book列表传递给网页
        return "book_list";  // 打开这个网页
    }

    @GetMapping("/books/detail/{id}")
    public String detailBook(@PathVariable Integer id, Model model){
        Book book = bookService.getBookById(id);
        book.setView_time(book.getView_time()+1);
        model.addAttribute("book", book);
        bookService.updateBook(book.getId(), book);
        return "book_detail";
    }
}
