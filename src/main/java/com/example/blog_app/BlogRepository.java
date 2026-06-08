package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
 private final JdbcClient jdbcClient;

 public BlogRepository(JdbcClient jdbcClient){
    this.jdbcClient=jdbcClient;
 }

 public List<Blog> findAll(){
    return jdbcClient.sql("SELECT id,name,title,notes FROM blog" )
        .query(Blog.class)
        .list();
 }

 public List<Blog> searchByTitle(String keyword) {
  return jdbcClient.sql("SELECT id,name,title,notes FROM blog WHERE title LIKE :keyword")
      .param("keyword", "%" + keyword + "%")
      .query(Blog.class)
      .list();
}

public void save(Blog blog) {
  jdbcClient.sql("INSERT INTO blog (id,name,title, notes) VALUES (:id,:name,:title,:notes)")
      .param("id", blog.getId())
      .param("name",blog.getName())
      .param("title",blog.getTitle())
      .param("notes",blog.getNotes())
      .update();

}

//タイトルの処理
    
}