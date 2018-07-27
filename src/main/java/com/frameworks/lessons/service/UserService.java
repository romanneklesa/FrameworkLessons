package com.frameworks.lessons.service;

import com.frameworks.lessons.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService  {
    User findByName(String name);
    User findById(int id);

    void add(User user);
    void update(User user);
    void delete(User user);

    List<User> listUsers();

    void save(User user);

    public UserDetails loadUserByUsername(String name);




}
