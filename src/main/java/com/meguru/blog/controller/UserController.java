package com.meguru.blog.controller;


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

@WebServlet("/user/*")
public class UserController extends BaseController{

    UserService userService = new UserServiceImpl();
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result= Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(null != token){
            if (!JwtHelper.isExpiration(token)) {
                result= Result.ok(null);
            }
        }
        WebUtil.writeJson(resp,result);
    }

    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result= Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(null != token && (!"".equals(token))){
            if (!JwtHelper.isExpiration(token)) {
                Integer userId = JwtHelper.getUserId(token).intValue();
                User user =userService.getUserById(userId);
                if(null != user){
                    //通过校验 查询用户信息放入Result
                    Map data =new HashMap();
                    user.setUserPwd("");
                    data.put("loginUser",user);
                    result = Result.ok(data);
                }
            }
        }

        WebUtil.writeJson(resp,result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        {
//            "email":"zhangsan@ssss.com",
//            "userPwd":"123456"
//        }
        User paramUser = WebUtil.readJson(req, User.class);

        // 调用服务层方法 实现登录
        User loginUser = userService.getUserByEmail(paramUser.getEmail());
        Result result = null;
        if(null != loginUser){
            if (MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())) {
//                System.out.println(loginUser.getUid());
//                System.out.println(loginUser.getEmail());
                Map data =new HashMap();
                data.put("token",JwtHelper.createToken(loginUser.getUid().longValue(),loginUser.getEmail()));
                result=Result.ok(data);
            }else{
                result=Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }
        }else {
            result=Result.build(null, ResultCodeEnum.EMAIL_ERROR);

        }

        // 向客户端响应登录验证信息
        WebUtil.writeJson(resp,result);
    }

}
