package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Service;

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

//同じタイトルがあったらエラーの処理をする続き　参照:サービスとリポジトリ
}
