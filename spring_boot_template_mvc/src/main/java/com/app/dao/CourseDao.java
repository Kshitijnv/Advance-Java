package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
}
