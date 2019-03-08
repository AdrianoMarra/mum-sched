package mum.sched.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.sched.model.Student;
import mum.sched.repository.StudentRepository;
import mum.sched.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> findOne(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}