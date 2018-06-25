package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dao.IStudentDao;
import com.pojo.po.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Resource
	private SessionFactory sessionFactory;

	public Student get(int id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	public int add(Student student) {
		return (Integer) sessionFactory.getCurrentSession().save(student);
	}

	public void delete(int id) {
		Student student = new Student();
		student.setId(id);
		sessionFactory.getCurrentSession().delete(student);
	}
}
