package mum.sched.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.sched.model.Course;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {
}