package com.app.service;

import java.util.List;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface StudentService {
	public String addStudent(Student student);

	public List<Student> displayStudents();

	public List<Student> findByCourse(Course myCourse);
}
