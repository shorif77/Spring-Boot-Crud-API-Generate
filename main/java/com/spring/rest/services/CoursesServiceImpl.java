package com.spring.rest.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.CourseDao;
import com.spring.rest.entities.Course;

@Service
public class CoursesServiceImpl implements CoursesServices {
	
	
	@Autowired
	private CourseDao courseDao;
	


	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseid) {
		
		return courseDao.getById(courseid);
	}

	

	@Override
	public Course addCourse(Course course) {
	
		 courseDao.save(course);
		 return course;
	}



	@Override
	public Course updateCourse(Course course) {
		
		courseDao.save(course);
		return course;
	}



	@Override
	public Course deleteCourse(long parseLong) {
		
		Course entity= courseDao.getById(parseLong);
		
		courseDao.delete(entity);
		return entity;
			
		
	}
	
	
	
	

}
