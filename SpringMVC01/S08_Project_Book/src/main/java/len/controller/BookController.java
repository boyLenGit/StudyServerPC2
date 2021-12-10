<<<<<<< HEAD
package len.controller;

import len.pojo.Books;
import len.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/queryAllBooks")
    public String queryAllBooks(Model model){
        List<Books> lists = bookService.queryAllBooks();
        for (Books books1 :lists){
            System.out.println("Test"+books1);
        }
        model.addAttribute("list", lists);
        return "queryAllBooks_table";
    }

    @RequestMapping("/queryBooksById")
    public String queryBooksById(int bookId, Model model){
        Books book = bookService.queryBookById(bookId);
        System.out.println("queryBooksById:"+book);
        model.addAttribute("list", book);
        return "queryAllBooks";
    }

    // 跳转功能
    @RequestMapping("/addBook_form")
    public String addBook_form(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book){
        System.out.println("addBook:"+book);
        bookService.addBook(book);
        return "redirect:/book/queryAllBooks";
    }

    // 更新用户
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int bookId){
        System.out.println("toUpdateBook:"+bookId);
        Books book = bookService.queryBookById(bookId);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        System.out.println("updateBook:"+book);
        bookService.updateBook(book);
        return "redirect:/book/queryAllBooks";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId")int bookId){
        System.out.println("updateBook:"+bookId);
        bookService.deleteBookById(bookId);
        return "redirect:/book/queryAllBooks";
    }


    @RequestMapping("/queryBookByName")
    public String queryBookByName(String queryBookName, Model model){
        System.out.println("queryBookByName:"+queryBookName);
        Books book = bookService.queryBookByName(queryBookName);
        List<Books> list_book = new ArrayList<Books>();
        list_book.add(book);
        model.addAttribute("error","查询成功");
        if (book == null) {
            list_book = bookService.queryAllBooks();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list", list_book);
        return "queryAllBooks_table";
    }
}
=======
package len.controller;

import len.pojo.Books;
import len.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/queryAllBooks")
    public String queryAllBooks(Model model){
        List<Books> lists = bookService.queryAllBooks();
        for (Books books1 :lists){
            System.out.println("Test"+books1);
        }
        model.addAttribute("list", lists);
        return "queryAllBooks_table";
    }

    @RequestMapping("/queryBooksById")
    public String queryBooksById(int bookId, Model model){
        Books book = bookService.queryBookById(bookId);
        System.out.println("queryBooksById:"+book);
        model.addAttribute("list", book);
        return "queryAllBooks";
    }

    // 跳转功能
    @RequestMapping("/addBook_form")
    public String addBook_form(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book){
        System.out.println("addBook:"+book);
        bookService.addBook(book);
        return "redirect:/book/queryAllBooks";
    }

    // 更新用户
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int bookId){
        System.out.println("toUpdateBook:"+bookId);
        Books book = bookService.queryBookById(bookId);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        System.out.println("updateBook:"+book);
        bookService.updateBook(book);
        return "redirect:/book/queryAllBooks";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId")int bookId){
        System.out.println("updateBook:"+bookId);
        bookService.deleteBookById(bookId);
        return "redirect:/book/queryAllBooks";
    }


    @RequestMapping("/queryBookByName")
    public String queryBookByName(String queryBookName, Model model){
        System.out.println("queryBookByName:"+queryBookName);
        Books book = bookService.queryBookByName(queryBookName);
        List<Books> list_book = new ArrayList<Books>();
        list_book.add(book);
        model.addAttribute("error","查询成功");
        if (book == null) {
            list_book = bookService.queryAllBooks();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list", list_book);
        return "queryAllBooks_table";
    }
}
>>>>>>> 1da3f48 (first commit)
