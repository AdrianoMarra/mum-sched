package mum.sched.service;

import java.util.List;
import java.util.Optional;

import mum.sched.model.Course;

public interface CourseService {
    List<Course> findAll();

    Course save(Course student);

    Optional<Course> findOne(Long id);

    void delete(Long id);
}