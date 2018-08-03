package com.frameworks.lessons.dao.impl;

import com.frameworks.lessons.dao.AccountDao;
import com.frameworks.lessons.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private static final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void add(Account account) {
        sessionFactory.getCurrentSession().save(account);
        logger.info("Account saved successfully, Account Details = " + account);
    }

    @Override
    public Account getAccount(int id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.load(Account.class, id);
        logger.info("Account loaded successfully, Account details = " + account);
        return account;
    }

    @Override
    public void deleteAccount(int id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.load(Account.class, id);
        if (account != null) {
            session.delete(account);
        }
        logger.info("Account deleted successfully, account details = " + account);
    }

    @Override
    public void updateAccount(Account account) {
        sessionFactory.getCurrentSession().update(account);
        logger.info("Account updated successfully, Account Details = " + account);
    }

    @Override
    public List<Account> listAccounts() {
        @SuppressWarnings("unchecked")
        List<Account> accountsList = sessionFactory.getCurrentSession().createQuery("from Account").getResultList();
        for (Account account : accountsList) {
            logger.info("Account List::" + account);
        }
        return accountsList;
    }

    @Override
    @Transactional
    public List<Account> getAccountsByUserId(Integer userId) {
        return sessionFactory.getCurrentSession().createQuery("from Account a join fetch a.user.roles where a.user.id=" + userId).getResultList();
    }
}
