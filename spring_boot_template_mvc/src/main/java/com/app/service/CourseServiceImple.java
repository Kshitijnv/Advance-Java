package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.pojos.Course;

@Service
public class CourseServiceImple implements CourseService {
	@Autowired
	private CourseDao courseDao;

	public List<Course> getAllCourses() {
		return courseDao.findAll();
	}

	public void addCourse(Course course) {
		courseDao.save(course);
	}

	public void updateCourse(Course course) {
		courseDao.save(course);
	}

	public void deleteCourse(Long id) {
		courseDao.deleteById(id);
	}

	public Course getCourseById(Long id) {
		return courseDao.findById(id).orElse(null);
	}
}
