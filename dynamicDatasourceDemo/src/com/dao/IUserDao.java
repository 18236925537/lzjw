package com.dao;

import java.util.List;

import com.pojo.po.User;

public interface IUserDao {

	List<User> findAll();

	int add(User user);

	void update(User user);
}
