package mum.sched.service;

import java.util.List;
import java.util.Optional;

import mum.sched.model.Student;

public interface StudentService {
	List<Student> findAll();

	Student save(Student student);

	Optional<Student> findOne(Long id);

	void delete(Long id);
}