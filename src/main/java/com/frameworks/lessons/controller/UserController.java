package com.frameworks.lessons.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
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
		List<Account> accounts;
		User currentUser=null;
		
		try {
			String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();		
			currentUser = userService.findByName(currentUserName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(currentUser!=null) accounts=accountService.getAccountsByUserId(currentUser.getId());
		else accounts=new ArrayList<>();
	
		return accounts;
	}

	@PostMapping(value = "/updateamount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public boolean updateAmount(@RequestParam("account_id") String account_id, @RequestParam("amount") String amount) {
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

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getAccounts(@RequestParam("id") int id) {
		return accountService.getAccountsByUserId(id);
    }
}
