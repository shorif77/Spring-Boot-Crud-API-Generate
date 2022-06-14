package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	
	

}
