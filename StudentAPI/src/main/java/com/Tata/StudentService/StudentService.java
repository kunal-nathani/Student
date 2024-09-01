package com.Tata.StudentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tata.Student;
import com.Tata.StudentRepository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	public Optional<Student> getStudentById(int id){
		return studentRepository.findById(id);
	}
	
	public Student updateStudent(int id,Student updatestudent) {
		return studentRepository.findById(id).map(student->{
		student.setName(student.getName());
		student.setMarks(student.getMarks());
		student.setStandard(student.getStandard());
		return studentRepository.save(student);
		}).orElseThrow(()->new RuntimeException("Student not found"));
	}
	
	 public void deleteStudent(int id) {
	        studentRepository.deleteById(id);
	    }
	
	

}
