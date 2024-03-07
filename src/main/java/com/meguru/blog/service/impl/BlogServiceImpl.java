package com.meguru.blog.service.impl;

import com.meguru.blog.dao.BlogDao;
import com.meguru.blog.dao.impl.BlogDaoImpl;
import com.meguru.blog.pojo.Blog;
import com.meguru.blog.service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    private BlogDao blogDao=new BlogDaoImpl();
    @Override
    public List<Blog> getRecentBlogs() {
        return blogDao.findRecentByNumber(3);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public Blog getBlogById(Integer id) {
        blogDao.increaseViewNumber(id);
        return blogDao.findBlogById(id);
    }

    @Override
    public int addBlog(Blog blog) {
//        blog.setCreateTime(new java.util.Date());
//        blog.setUpdateTime(new java.util.Date());
        return blogDao.addBlog(blog);
    }

    // updateBlog
    @Override
    public int updateBlog(Blog blog) {
//        blog.setUpdateTime(new java.util.Date());
        return blogDao.updateBlog(blog);
    }
    // deleteBlog
    @Override
    public int deleteBlog(int bid) {
        return blogDao.deleteBlog(bid);
    }
}
