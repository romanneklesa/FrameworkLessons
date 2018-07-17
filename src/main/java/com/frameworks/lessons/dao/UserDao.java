package com.frameworks.lessons.dao;

import com.frameworks.lessons.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User getUser(int id);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> listUsers();

    User findByName(String name);

}

