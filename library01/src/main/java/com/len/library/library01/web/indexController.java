package com.len.library.library01.web;

import com.len.library.library01.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
