package com.service;

import java.util.List;

import com.pojo.po.User;

public interface IUserService {

	List<User> findAll();

	int add(User user);

	void update(User user);
}
