package com.frameworks.lessons.service;

import com.frameworks.lessons.entity.Account;

import java.util.List;

public interface AccountService {
	
	Account getById(int id);

	void add(Account account);
	void update(Account account);
	void delete(Account account);

	List<Account> listAccounts();
	
}
