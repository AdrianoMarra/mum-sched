package mum.sched.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.sched.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
}