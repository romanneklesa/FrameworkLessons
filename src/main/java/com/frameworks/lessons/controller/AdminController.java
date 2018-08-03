package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by papus on 28.07.2018.
 */
@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.listUsers();
    }
}
