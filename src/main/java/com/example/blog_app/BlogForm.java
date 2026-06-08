package com.example.blog_app;

public class BlogForm {
    private final String name;
    private final String title;

    public BlogForm(String name,String title){
        this.name=name;
        this.title=title;
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
}
