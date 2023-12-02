package com.app.dao;

import java.util.List;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface StudentDao {
	public String addStudent(Student stud);

	public List<Student> displayStudents();

	public List<Student> findByCourse(Course myCourse);
}
