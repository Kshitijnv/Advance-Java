package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public String addStudent(Student stud) {
		// TODO Auto-generated method stub
		mgr.persist(stud);
		return "Student added successfully";
	}

	@Override
	public List<Student> displayStudents() {
		String jpql = "select s from Student s";
		return mgr.createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public List<Student> findByCourse(Course myCourse) {
		String jpql = "select s from Student s where s.courseName=:course";
		return mgr.createQuery(jpql, Student.class).setParameter("course", myCourse).getResultList();
	}

}
