package com.frameworks.lessons.service;

import java.util.List;

import com.frameworks.lessons.entity.Account;

public interface AccountService {
	
	Account getById(int id);

	void add(Account account);
	void update(Account account);
	void delete(Account account);

	List<Account> listAccounts();
	List<Account> getAccountsByUserId(int userId);
	
}
