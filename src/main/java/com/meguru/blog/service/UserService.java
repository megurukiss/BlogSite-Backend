package com.meguru.blog.service;

import com.meguru.blog.pojo.User;
public interface UserService {
    User getUserById(Integer uid);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    int addUser(User user);
}
