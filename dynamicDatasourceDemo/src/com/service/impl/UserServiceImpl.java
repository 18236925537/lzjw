package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IUserDao;
import com.pojo.po.User;
import com.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public int add(User user) {
		return userDao.add(user);
	}

	public void update(User user) {
		userDao.update(user);
	}
}
