package com.meguru.blog.dao.impl;

import com.meguru.blog.dao.BaseDao;
import com.meguru.blog.dao.UserDao;
import com.meguru.blog.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public User getUserById(Integer uid) {
        String sql= "select id uid,username,password userPwd,email from user where id = ?";
        List<User> userList = baseQuery(User.class, sql, uid);
        return userList != null  && !userList.isEmpty() ? userList.getFirst():null ;
    }

    @Override
    public User getUserByUsername(String username) {
        String sql= "select id uid,username,password userPwd,email from user where username = ?";
        List<User> userList = baseQuery(User.class, sql, username);
        return userList != null  && !userList.isEmpty() ? userList.getFirst():null ;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql= "select id uid,username,password userPwd,email from user where email = ?";
        List<User> userList = baseQuery(User.class, sql, email);
        return userList != null  && !userList.isEmpty() ? userList.getFirst():null ;
    }

    @Override
    public int addUser(User user) {
        String sql = """
                insert into user values (DEFAULT,?,?,?)
                """;
        return baseUpdate(sql,
                user.getUsername(),
                user.getUserPwd(),
                user.getEmail()
        );
    }
}
