package com.frameworks.lessons.service.impl;

import com.frameworks.lessons.dao.AccountDao;
import com.frameworks.lessons.dao.UserDao;
import com.frameworks.lessons.entity.Account;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.model.Role;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private AccountDao accountDao;
/*
	@Autowired
	private RoleDao roleDao;*/

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return dao.getUser(id);
    }
	@Override
	@Transactional(readOnly=true)
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}



    @Override
    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        dao.updateUser(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        List<Account> accountList = accountDao.getAccountsByUserId(user.getId());
        for(Account ac : accountList){
            accountDao.deleteAccount(ac.getId());
        }
        dao.deleteUser(user.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return dao.listUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        Account account;
        if (!passwordEncoder.matches(user.getPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user.setRole(Role.USER);
        dao.add(user);
        for (int i = 0; i < 3; i++) {
            account = new Account();
            account.setAmount(0);
            account.setUser(user);
            accountDao.add(account);
        }
    }
}


