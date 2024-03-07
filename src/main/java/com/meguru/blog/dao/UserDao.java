package com.meguru.blog.dao;

import com.meguru.blog.pojo.User;

public interface UserDao {
    User getUserById(Integer uid);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    int addUser(User user);
}
