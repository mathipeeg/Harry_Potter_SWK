package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    FanMailRepository fanMailRepository;
    @Autowired
    FanMailService fanMailService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/movies")
    public String movies(){
        return "movies";
    }

    @GetMapping("/books")
    public String books(){
        return "books";
    }

    @GetMapping("/fanmail")
    public String fanmail(ModelMap model){
        ArrayList<FanMail> fanMailArray = fanMailRepository.getAllMail();
        model.addAttribute("mails", fanMailArray);
        return "fanmail";
    }

    @GetMapping("/newMail")
    public String newMail(){
        return "newMail";
    }

    @PostMapping("/createMail")
    public String createMail(@ModelAttribute FanMail fanmail){
        fanMailService.createMail(fanmail);
        return "redirect:/fanmail";
    }

    @GetMapping("/englishBookReviews")
    public String englishBooksReviews(){
        return "englishBookReviews";
    }

    @GetMapping("/danishBookReviews")
    public String danishBooksReviews(){
        return "danishBookReviews";
    }
}
