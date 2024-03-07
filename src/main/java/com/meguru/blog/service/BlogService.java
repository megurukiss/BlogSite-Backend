package com.meguru.blog.service;

import com.meguru.blog.pojo.Blog;
import java.util.List;

public interface BlogService {

    List<Blog> getRecentBlogs();

    List<Blog> getAllBlogs();

    Blog getBlogById(Integer id);

    int addBlog(Blog blog);
    int updateBlog(Blog blog);
    int deleteBlog(int bid);
}
