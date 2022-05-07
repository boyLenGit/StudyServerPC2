package com.len.library.library01.web.admin;

import com.len.library.library01.pojo.Book;
import com.len.library.library01.service.BookService;
import com.len.library.library01.util.LenFile;
import com.len.library.library01.util.LenLog;
import com.len.library.library01.util.LenPath;
import com.len.library.library01.util.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class bookControllerAdmin {
    @Autowired
    private BookService bookService;

    // 添加book-跳转
    @GetMapping("/books/add")
    public String addBook_jump(Model model){
        Book book = new Book();
        book.setView_time(0);
        model.addAttribute("book", book);
        return "book_add";
    }

    // 添加book
    @PostMapping("/books/add")
    public String addBook(@Valid Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes, MultipartFile image1) throws IOException {
        LenLog.info("addBook", book.toString());
        // 写入文件
        String file_path = "https://picsum.photos/300/400";
        if (image1 != null){
            file_path = "/upload/book_picture/" + book.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String file_path_store = LenPath.getData() + file_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
        }
        LenLog.info("addBook", file_path);
        book.setPicture(file_path);
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
    public String updateBook_Post(@Valid Book book, BindingResult bindingResult, @PathVariable Integer id, MultipartFile image1) throws IOException {
        if(image1!=null){
            // 储存新文件
            String file_path = "/upload/book_picture/" + book.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String file_path_store = LenPath.getData() + file_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
            // 删除旧文件
            String delete_path = LenPath.getData() + bookService.getBookById(id).getPicture();
            LenFile.deleteFile(delete_path);
            // 新路径写入属性
            book.setPicture(file_path);
        }
        LenLog.info("updateBook_Post", id + " | " + book.toString());
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // 删除book
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id, Model model) throws IOException {
        String delete_path = LenPath.getData() + bookService.getBookById(id).getPicture();
        LenLog.info("deleteBook", String.valueOf(id) + " " + delete_path);
        LenFile.deleteFile(delete_path);
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
