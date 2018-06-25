package com.dao;

import com.pojo.po.Student;

public interface IStudentDao {

	Student get(int id);

	int add(Student student);

	void delete(int id);
}
