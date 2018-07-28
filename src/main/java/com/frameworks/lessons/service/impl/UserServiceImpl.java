package com.frameworks.lessons.service.impl;

import com.frameworks.lessons.dao.RoleDao;
import com.frameworks.lessons.dao.UserDao;
import com.frameworks.lessons.entity.Role;
import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional(readOnly=true)
	public User findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(int id) {
		return dao.getUser(id);
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
		dao.deleteUser(user.getId());
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> listUsers() {
		return dao.listUsers();
	}

	@Override
	@Transactional
	public void save(User user) {
	//	user.setPassword(user.getPassword());
		Role roleUser = roleDao.findOne(2); // если ROLE_USER гарантирована с id=2
		Set<Role> roles = new HashSet<>();
		roles.add(roleUser);
		user.setRole(roles);
		dao.add(user);

	}
}


