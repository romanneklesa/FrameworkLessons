package com.frameworks.lessons.dao.impl;

import com.frameworks.lessons.dao.UserDao;
import com.frameworks.lessons.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
        logger.info("User saved successfully, User Details="+user);
    }

    @Override
    public User getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User loaded successfully, User details="+user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if(null != user){
            session.delete(user);
        }
        logger.info("User deleted successfully, user details="+user);

    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        logger.info("User updated successfully, User Details="+user);
    }

    @Override
    public List<User> listUsers() {
        @SuppressWarnings("unchecked")
        List<User> userList = sessionFactory.getCurrentSession().createQuery("from user").getResultList();
        for(User user : userList){
            logger.info("User List::"+user);
        }
        return userList;
    }

}
