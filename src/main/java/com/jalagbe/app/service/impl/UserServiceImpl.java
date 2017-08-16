package com.jalagbe.app.service.impl;

import com.jalagbe.app.dao.UserDao;
import com.jalagbe.app.entity.User;
import com.jalagbe.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	@Override
	public boolean save(User object) throws Exception {
		return false;
	}

	@Override
	public boolean delete(User object) throws Exception {
		return false;
	}

	@Override
	public boolean update(User object) throws Exception {
		return false;
	}

	@Override
	public List<User> getAll() throws Exception {
		return null;
	}

	@Override
	public User get(Integer id) throws Exception {
		return null;
	}

	@Override
	public List<User> getDataBy(String columnName, String input) throws Exception {
		return null;
	}
}
