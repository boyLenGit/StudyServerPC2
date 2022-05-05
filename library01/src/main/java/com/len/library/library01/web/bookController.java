package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import com.len.library.library01.util.LenLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
        model.addAttribute("book", book);
        return "book_add";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        LenLog.info("addBook", book.toString());
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/modify_get/{id}")
    public String modifyBook_Get(@PathVariable Integer id, Model model){
        LenLog.info("modifyBook_Get", String.valueOf(id));
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        LenLog.info("modifyBook_Get", book.toString());
        return "book_modify";
    }

    @PostMapping("/books/modify_post/{id}")
    public String modifyBook_POST(@Valid Book book, BindingResult bindingResult, @PathVariable Integer id, RedirectAttributes redirectAttributes){
        LenLog.info("modifyBook", book.toString());
        bookService.modifyBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id, Model model){
        LenLog.info("deleteBook", String.valueOf(id));
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
