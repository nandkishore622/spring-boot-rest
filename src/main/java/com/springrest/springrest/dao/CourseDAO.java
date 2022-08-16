package com.springrest.springrest.dao;

import com.springrest.springrest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CourseDAO extends JpaRepository<Course, Long> {
    public Course getCourseByCourseTitle(String courseTitle);
}
