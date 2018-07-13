package com.frameworks.lessons.service;

import com.frameworks.lessons.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}
