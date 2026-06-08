package com.example.blog_app;

public class Blog {
    private final Long id;
    private final String name;
    private final String title;
    private  final String notes;
    public Blog(Long id,String name,String title,String notes){
        this.id=id;
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

    public Long getId() {
        return id;
    }

    
}
