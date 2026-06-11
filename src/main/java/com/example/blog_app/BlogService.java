package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository=blogRepository;
    }
    public List<Blog> search(String keyword) {
  if (keyword == null || keyword.isBlank()) {
    return blogRepository.findAll();
  }
  return blogRepository.searchByTitle(keyword);
}

public void add(BlogForm form){{
   blogRepository.save(new Blog(null, form.getName(), form.getTitle(), form.getNotes()));
}}    

public Optional<Blog> findById(Long id) {
  return blogRepository.findById(id);
}

public void delete(Long id) {
  blogRepository.deleteById(id);
}


}
