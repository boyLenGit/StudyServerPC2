<<<<<<< HEAD
package len.controller;

import len.pojo.Books;
import len.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook_len")
    public String list(Model model){
        List<Books> lists = bookService.queryAllBooks();
        for (Books books1 :lists){
            System.out.println("Test"+books1);
        }
        model.addAttribute("list", lists);
        return "allBook_len";
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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook_len")
    public String list(Model model){
        List<Books> lists = bookService.queryAllBooks();
        for (Books books1 :lists){
            System.out.println("Test"+books1);
        }
        model.addAttribute("list", lists);
        return "allBook_len";
    }
}
>>>>>>> 1da3f48 (first commit)
