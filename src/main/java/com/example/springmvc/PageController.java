package com.example.springmvc;

import com.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PageController {
    UserRepository userRepository = new UserRepository();

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("user",new User("",""));
        return "form";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users", userRepository.users);
        return "list";
    }

    @DeleteMapping("/list/{userName}")
    public RedirectView delete(@PathVariable("userName") String userName, Model model){
        userRepository.delete(userName);
        model.addAttribute("users", userRepository.users);

        return new RedirectView("/list");
    }

    @GetMapping("/details/{userName}")
    public String details(@PathVariable("userName") String userName, Model model){
        model.addAttribute("user", userRepository.find(userName));
        return "details";
    }

    @PostMapping("/list")
    public String createUser(@ModelAttribute User user, Model model){
        userRepository.createUser(user);
        model.addAttribute("users", userRepository.users);
        return "list";

    }
}



