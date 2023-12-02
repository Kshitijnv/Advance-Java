package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentDao;
import com.app.pojos.Course;
import com.app.pojos.Student;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao stuDao;
	@Override
	public String addStudent(Student student) {
		String addStudent = stuDao.addStudent(student);
		return addStudent;
	}
	@Override
	public List<Student> displayStudents() {
		List<Student> list = stuDao.displayStudents();
		return list;
	}
	@Override
	public List<Student> findByCourse(Course myCourse) {
		List<Student> list = stuDao.findByCourse(myCourse);
		return list;
	}

}
