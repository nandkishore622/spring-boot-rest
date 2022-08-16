package com.springrest.springrest.service;

import com.springrest.springrest.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourseById(Long courseId);
    public Course addCourse(Course course);

    Course updateCourse(Course course);

    boolean deleteCourse(long courseId);

    Course getCourseByTitle(String courseTitle);
}
