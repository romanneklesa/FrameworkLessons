package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.AccountService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
    private AccountService accountService;
    
    @GetMapping(value = "/user")
    private ModelAndView user(ModelAndView view) {
        view.setViewName("user");
        return view;
    }
    
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getAccounts(@RequestParam("id") int id) {
    	List<Account> accounts=accountService.getAccountsByUserId(id);
      return accounts;
    }
}