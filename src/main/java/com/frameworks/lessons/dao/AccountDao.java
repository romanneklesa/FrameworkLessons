package com.frameworks.lessons.dao;

import com.frameworks.lessons.entity.Account;

import java.util.List;

public interface AccountDao {
    void add(Account account);
    Account getAccount(int id);
    void deleteAccount(int id);
    void updateAccount(Account account);
    List<Account> listAccounts();
    List<Account> getAccountsByUserId(Integer userId);
}
