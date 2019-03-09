package mum.sched.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.sched.model.Course;
import mum.sched.repository.CourseRepository;
import mum.sched.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRespository;

    @Override
    public List<Course> findAll() {
        return courseRespository.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRespository.save(course);
    }

    @Override
    public Optional<Course> findOne(Long id) {
        return courseRespository.findById(id);
    }

    @Override
    public void delete(Long id) {
        courseRespository.deleteById(id);
    }
}