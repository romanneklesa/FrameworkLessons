package com.frameworks.lessons.dao.impl;

import com.frameworks.lessons.dao.RoleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findOne(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        //logger.info("User loaded successfully, User details="+user);
        return role;
    }
}
