package com.meguru.blog.dao;

import com.meguru.blog.pojo.Blog;
import java.util.List;
public interface BlogDao {
    List<Blog> findRecentByNumber(int num);
    List<Blog> findAll();
    int addBlog(Blog blog);
    Blog findBlogById(int bid);
    int updateBlog(Blog blog);
    int deleteBlog(int bid);
    int increaseViewNumber(int bid);
}
