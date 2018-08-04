package com.frameworks.lessons.dao.impl;

import com.frameworks.lessons.dao.RoleDao;
import com.frameworks.lessons.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
