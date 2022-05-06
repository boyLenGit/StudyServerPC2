package com.len.library.library01.web;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import com.len.library.library01.util.LenLog;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    // 添加book-跳转
    @GetMapping("/books/add")
    public String addBook_jump(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "book_add";
    }

    // 添加book
    @PostMapping("/books/add")
    public String addBook(@Valid Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        LenLog.info("addBook", book.toString());
        bookService.addBook(book);
        return "redirect:/books";
    }

    // 修改book-跳转
    @GetMapping("/books/modify/{id}/get")
    public String updateBook_Get(@PathVariable Integer id, Model model){
        LenLog.info("updateBook_Get", String.valueOf(id));
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        LenLog.info("updateBook_Get", book.toString());
        return "book_modify";
    }

    // 修改book
    @PostMapping("/books/modify/{id}")
    public String updateBook_Post(@Valid Book book, BindingResult bindingResult, @PathVariable Integer id, RedirectAttributes redirectAttributes){
        LenLog.info("updateBook_Post", id + " | " + book.toString());
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // 删除book
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id, Model model){
        LenLog.info("deleteBook", String.valueOf(id));
        bookService.deleteBook(id);
        return "redirect:/books";
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
