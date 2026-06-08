package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class BlogController {
    private final BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService=blogService;
    }
    
    @GetMapping("/blog")
    public String blog(@RequestParam(required = false) String keyword,Model model){
        model.addAttribute("blog",blogService.search(keyword));
        return "blog";
    }

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @GetMapping("/view")
    public String view(){
        return "view";
    }

    @PostMapping("/blog")
    public String newblog(){
        return  "redirect:/blog";
    }

   
    
}
