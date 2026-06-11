package com.example.blog_app;

public class BlogForm {
    private final String name;
    private final String title;
    private final String notes;

    public BlogForm(String name,String title,String notes){
        this.name=name;
        this.title=title;
        this.notes=notes;
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }
}
