package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/books/add")
    public String addBook_jump(Model model){
        Book book = new Book();
        book.setName("博客名称测试");
        model.addAttribute("book", book);
        return "add_book";
    }

    @PostMapping("/books/add_main")
    public String addBook(Book book, RedirectAttributes redirectAttributes, HttpSession httpSession){
        System.out.println("LenTest-addBook: " + book.toString());
        bookService.addBook(book);
        return "redirect:/books";
    }
}
