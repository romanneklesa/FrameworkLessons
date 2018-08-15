package com.frameworks.lessons.service.impl;

import com.frameworks.lessons.dao.AccountDao;
import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao dao;

	@Override
	@Transactional(readOnly=true)
	public Account getById(int id) {
		return dao.getAccount(id);
	}

	@Override
	@Transactional
	public void add(Account account) {
		dao.add(account);
	}

	@Override
	@Transactional
	public void update(Account account) {
		dao.updateAccount(account);
	}

	@Override
	@Transactional
	public void delete(Account account) {
		dao.deleteAccount(account.getId());
	}

	@Override
	public List<Account> getAccountsByUserId(int userId) {
		List<Account> accounts=dao.getAccountsByUserId(userId);
		return accounts;
	}

}
