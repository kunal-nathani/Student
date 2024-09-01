package com.Tata.StudentController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tata.Student;
import com.Tata.StudentService.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student createStudent(@RequestBody Student student){
		return studentService.createStudent(student);
	}
	
	 @GetMapping
	    public List<Student> getAllStudents(){
		 return studentService.getAllStudents();
	    }
	 
	 @GetMapping("/{id}")
	    public Optional<Student> getStudentById(@PathVariable int id){
		 return studentService.getStudentById(id);
	    }
	 
	 @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
	        return studentService.updateStudent(id, student);
	    }
	 
	 @DeleteMapping("/{id}")
	    public String deleteStudent(@PathVariable int id) {
	        studentService.deleteStudent(id);
	        return "redirect:/students"; // Redirect to the list of students after deletion
	    }
	 
}
