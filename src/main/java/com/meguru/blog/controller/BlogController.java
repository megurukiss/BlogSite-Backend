package com.meguru.blog.controller;

import com.meguru.blog.pojo.Blog;
import com.meguru.blog.service.BlogService;
import com.meguru.blog.service.impl.BlogServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import com.meguru.blog.pojo.User;
import com.meguru.blog.service.UserService;
import com.meguru.blog.service.impl.UserServiceImpl;
import com.meguru.blog.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.meguru.blog.common.Result;
import com.meguru.blog.common.ResultCodeEnum;
import com.meguru.blog.util.JwtHelper;
import com.meguru.blog.util.WebUtil;

@WebServlet("/blog/*")
public class BlogController extends BaseController{


    BlogService blogService = new BlogServiceImpl();

    protected void deleteBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        if(null != token && (!"".equals(token))){
            if (!JwtHelper.isExpiration(token)){
                Blog blog=WebUtil.readJson(req, Blog.class);
                if(null != blog){
                    int result = blogService.deleteBlog(blog.getBid());
                    if(result>0){
                        WebUtil.writeJson(resp,Result.ok(null));
                    }else{
                        WebUtil.writeJson(resp,Result.build(null,ResultCodeEnum.SERVER_ERROR));
                    }
                }
            }else{
                WebUtil.writeJson(resp,Result.build(null,ResultCodeEnum.NOTLOGIN));
            }
        }
    }

    protected void updateBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        if(null != token && (!"".equals(token))){
            if (!JwtHelper.isExpiration(token)){
                Blog blog=WebUtil.readJson(req, Blog.class);
                if(null != blog){
                    int result = blogService.updateBlog(blog);
                    if(result>0){
                        WebUtil.writeJson(resp,Result.ok(null));
                    }else{
                        WebUtil.writeJson(resp,Result.build(null,ResultCodeEnum.SERVER_ERROR));
                    }
                }
            }else{
                WebUtil.writeJson(resp,Result.build(null,ResultCodeEnum.NOTLOGIN));
            }
        }
    }

    protected void addBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        if(null != token && (!"".equals(token))){
            if (!JwtHelper.isExpiration(token)){
                Blog blog=WebUtil.readJson(req, Blog.class);
                // get uid from token
                Integer userId = JwtHelper.getUserId(token).intValue();
                if(null != blog){
                    blog.setUid(userId);
                    int result = blogService.addBlog(blog);
                    if(result>0){
                        WebUtil.writeJson(resp,Result.ok(null));
                    }else{
                        WebUtil.writeJson(resp,Result.build(null,ResultCodeEnum.SERVER_ERROR));
                    }
                }
            }else{
                WebUtil.writeJson(resp,Result.build(null,ResultCodeEnum.NOTLOGIN));
            }
        }
    }

}
