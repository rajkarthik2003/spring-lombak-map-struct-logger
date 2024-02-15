package com.karthik.learningportalnew.service;

import java.util.List;

import com.karthik.learningportalnew.dto.CourseDTO;
import com.karthik.learningportalnew.entity.CourseEntity;

public interface CourseService {

	//AUTHOR
	//get all courses
	List<CourseEntity> getAllCourses();

	//add courses
	CourseDTO addCourse(CourseDTO course);

	//delete courses
	void deleteCourse(Long courseId);

	//update course
	CourseDTO updateCourse(CourseDTO course);

}
