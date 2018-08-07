package com.frameworks.lessons.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import com.frameworks.lessons.service.AccountService;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by papus on 28.07.2018.
 */
@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/getusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {

        return userService.listUsers();
    }

    @PostMapping(value = "/deleteuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean deleteUser(@RequestParam("user_id") String user_id) {
        try {
            userService.delete(userService.findById(Integer.parseInt(user_id)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/updateaccount", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean updateAccount(@RequestParam("account_id") String account_id, @RequestParam("amount") String amount) {
        try {
            Account account = accountService.getById(Integer.parseInt(account_id));
            account.setAmount(Integer.parseInt(amount));
            accountService.update(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/updateuserrole", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean updateUserRole(@RequestParam("user_id") String user_id, @RequestParam("role_name") String role_name) {
        try {
            User user = userService.findById(Integer.parseInt(user_id));
            user.setRole(Role.valueOf(role_name));
            userService.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}