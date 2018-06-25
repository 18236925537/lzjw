package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.IUserDao;
import com.pojo.po.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public int add(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
}
