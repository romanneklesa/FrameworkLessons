package com.frameworks.lessons.service;

import com.frameworks.lessons.dao.impl.UserDaoImpl;
import com.frameworks.lessons.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// This class should be deleted. Full implemetation is in 'com.frameworks.lessons.service.impl' package
//@Service
public class UserServiceImpl /*implements UserService*/ {

    @Autowired
    private UserDaoImpl userDao;

    @Transactional
    //@Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    //@Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
