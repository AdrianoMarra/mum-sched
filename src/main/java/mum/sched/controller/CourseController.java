package mum.sched.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

import mum.sched.expection.*;

import mum.sched.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import mum.sched.model.Course;
import mum.sched.service.impl.CourseServiceImpl;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseServiceImpl.findAll();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getOneCourse(@PathVariable Long id) {
        return courseServiceImpl.findOne(id);
    }

    @PostMapping("/courses")
    public Course createUser(@Valid @RequestBody Course course) {
        return courseServiceImpl.save(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable(value = "id") Long courseID, @Valid @RequestBody Course updateCourse)
            throws ResourceNotFoundException {
        Course course =
                courseServiceImpl
                        .findOne(courseID)
                        .orElseThrow(() -> new ResourceNotFoundException("Course not found on : " + courseID));

        course.setName(updateCourse.getName());
        course.setCode(updateCourse.getCode());
        course.setCourse_level(updateCourse.getCourse_level());
        course.setDescription(updateCourse.getDescription());
        final Course updateCourseFinal = courseServiceImpl.save(course);
        return ResponseEntity.ok(updateCourseFinal);
    }


    @DeleteMapping("/courses/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long courseID) throws Exception {
        Course course =
                courseServiceImpl
                        .findOne(courseID)
                        .orElseThrow(() -> new ResourceNotFoundException("Course not found on :: " + courseID));
        courseServiceImpl.delete(courseID);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}