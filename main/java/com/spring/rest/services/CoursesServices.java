package com.spring.rest.services;

import java.util.List;

import com.spring.rest.entities.Course;

public interface CoursesServices {
	
	public List<Course> getCourses() ;
	
	public Course getCourse( long courseid);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	public Course deleteCourse(long parseLong);
		
	

}
