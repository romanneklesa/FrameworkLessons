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
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by papus on 28.07.2018.
 */
@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/admin")
    private ModelAndView admin(ModelAndView view) {
        view.setViewName("admin");
        return view;
    }

    @GetMapping(value = "/getusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {

        return userService.listUsers();
    }

    @PostMapping(value = "/adduser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean addNewUser(@RequestParam("user_name") String user_name, @RequestParam("pass") String pass, @RequestParam("role_name") String role) {
        try {
            User user = new User();
            user.setRole(Role.valueOf(role));
            user.setPassword(pass);
            user.setName(user_name);
            user.setEmail("test."+user_name+"@gmail.com");
            userService.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @PostMapping(value = "/deleteuser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public boolean deleteUser(@RequestParam("user_id") int user_id) {
        System.out.println(user_id);
        try {
            User user = userService.findById(user_id);

            System.out.println(user.toString());

            userService.delete(user);
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