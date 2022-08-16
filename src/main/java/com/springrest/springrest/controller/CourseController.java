package com.springrest.springrest.controller;

import com.springrest.springrest.model.Course;
import com.springrest.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
//@RequestMapping
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public String home() {
        return "welcome to courses application";
    }

    @GetMapping("/courses")
//    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {
        List<Course> courseList = courseService.getCourses();
        return courseList;
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId) {
        Course course = courseService.getCourseById(Long.parseLong(courseId));
        return course;
    }

    @GetMapping("/courses/getByCourseTitle/{courseTitle}")
    public Course getCourseByTitle(@PathVariable String courseTitle) {
        Course course = courseService.getCourseByTitle(courseTitle);
        return course;
    }

    @PostMapping("/courses")
    public Course addCourses(@RequestBody Course course) {
        Course cours = courseService.addCourse(course);
        return cours;
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        boolean courseDeleted = courseService.deleteCourse(Long.parseLong(courseId));

        if (courseDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*{
        "courseId":1,
        "courseTitle":"Core Java",
        "description":"This is Core Java course"
    }*/


}
