package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.Optional;

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
    public String newblog(BlogForm form){
        blogService.add(form);
        return  "redirect:/blog";
    }

     @GetMapping("/blog/{id}")
    public String detail(@PathVariable Long id,Model model){
        Optional<Blog> blogOpt = blogService.findById(id);
        if (blogOpt.isEmpty()) {
            return   "redirect:/blog";
        }
        model.addAttribute("blog",blogOpt.get());
        return "view";
    }

    @PostMapping("/blog/{id}/delete")
public String delete(@PathVariable Long id) {
  blogService.delete(id);
  return "redirect:/blog";
}
   
    
}
