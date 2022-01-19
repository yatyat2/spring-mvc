package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

//    @GetMapping("/details")
//    public String form(){
//        return "form";
//    }


}



