package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entities.Course;
import com.spring.rest.services.CoursesServices;

@org.springframework.stereotype.Controller
@RestController
public class Controller {
	
	@Autowired
	
	private CoursesServices coursesServices;
	
	@GetMapping ("/home")
	
	public String home() {
		
		return "wellcome to all courses application" ;
		
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		
		return this.coursesServices.getCourses();
		
	}
	
	@GetMapping("/courses/{courseid}")
	public Course getCourse( @PathVariable String courseid) {
		
		return this.coursesServices.getCourse(Long.parseLong(courseid));
		
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.coursesServices.addCourse(course);
	}
	
	@PutMapping("/courses")
	
	public Course updatecourse(@RequestBody Course course) {
		return this.coursesServices.updateCourse(  course);
	
	}
	
//	@DeleteMapping("/courses/{courseid}")
//	public Course deleteCourse(@PathVariable String courseid) {
//		
//		return this.coursesServices.deleteCourse(Long.parseLong(courseid));
//	}
	
	@DeleteMapping("/courses/{courseid}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseid){
		
		try {
			
			this.coursesServices.deleteCourse(Long.parseLong(courseid));
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	

}
