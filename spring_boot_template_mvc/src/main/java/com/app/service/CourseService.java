package com.app.service;

import java.util.List;

import com.app.pojos.Course;

public interface CourseService {
	List<Course> getAllCourses();

	void addCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(Long id);

	Course getCourseById(Long id);
}
