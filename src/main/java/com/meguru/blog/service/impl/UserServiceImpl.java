package com.meguru.blog.service.impl;

import com.meguru.blog.pojo.User;
import com.meguru.blog.service.UserService;
import com.meguru.blog.dao.UserDao;
import com.meguru.blog.dao.impl.UserDaoImpl;
import com.meguru.blog.util.MD5Util;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();
    @Override
    public User getUserById(Integer uid) {
        return userDao.getUserById(uid);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public int addUser(User user) {
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        return userDao.addUser(user);
    }
}
