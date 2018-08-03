package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.AccountService;
import com.frameworks.lessons.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user")
	private ModelAndView user(ModelAndView view) {
		view.setViewName("user");
		return view;
	}

	@RequestMapping(value = "/currentuseraccounts", method = RequestMethod.GET)
	@ResponseBody
	public List<Account> getCurrentUserAccounts() {		
				
		String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		User currentUser = userService.findByName(currentUserName);
		
		List<Account> accounts;
		if(currentUser!=null) accounts=accountService.getAccountsByUserId(currentUser.getId());
		else accounts=new ArrayList<>();
	
		return accounts;
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getAccounts(@RequestParam("id") int id) {
		return accountService.getAccountsByUserId(id);
    }
}
