package com.frameworks.lessons.service;

import com.frameworks.lessons.entity.User;
import java.util.List;

public interface UserService {

	User findByName(String name);

	User findById(int id);

    void add(User user);

    void update(User user);

    void delete(User user);

    List<User> listUsers();

    void save(User user);
}
