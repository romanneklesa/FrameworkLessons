package com.frameworks.lessons.dao;

import com.frameworks.lessons.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
}
