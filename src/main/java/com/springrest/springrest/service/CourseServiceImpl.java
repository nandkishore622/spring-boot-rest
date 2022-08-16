package com.springrest.springrest.service;

import com.springrest.springrest.dao.CourseDAO;
import com.springrest.springrest.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = courseDAO.findAll();
        return courseList;
    }

    @Override
    public Course getCourseById(Long courseId) {
        Optional<Course> course = courseDAO.findById(courseId);
        return course.get();
    }

    @Override
    public Course addCourse(Course course) {
        return courseDAO.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        boolean flag = courseDAO.existsById(course.getCourseId());

        if(flag) {
            return courseDAO.save(course);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCourse(long courseId) {
        Optional<Course> course = courseDAO.findById(courseId);

        if(course.isPresent()){
            courseDAO.delete(course.get());
            return true;
        }
        return false;
    }

    @Override
    public Course getCourseByTitle(String courseTitle) {
        Course course = courseDAO.getCourseByCourseTitle(courseTitle);
        return course;
    }
}
