package com.meguru.blog.controller;


import com.meguru.blog.common.Result;
import com.meguru.blog.pojo.Blog;
import com.meguru.blog.service.BlogService;
import com.meguru.blog.service.impl.BlogServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.meguru.blog.util.WebUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private BlogService blogService = new BlogServiceImpl();

    protected void getRecentBlogs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Blog> recentBlogs = blogService.getRecentBlogs();
        WebUtil.writeJson(resp, Result.ok(recentBlogs));
    }

    protected void getAllBlogs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Blog> allBlogs = blogService.getAllBlogs();
        WebUtil.writeJson(resp, Result.ok(allBlogs));
    }

    protected void getBlogById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Blog blog = WebUtil.readJson(req, Blog.class);
        Blog blogById = blogService.getBlogById(blog.getBid());
        WebUtil.writeJson(resp, Result.ok(blogById));
    }
}
