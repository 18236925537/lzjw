package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IStudentDao;
import com.pojo.po.Student;
import com.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Resource
	private IStudentDao studentDao;

	public Student get(int id) {
		return studentDao.get(id);
	}

	public int add(Student student) {
		return studentDao.add(student);
	}

	public void delete(int id) {
		studentDao.delete(id);
	}
}
