package com.Tata.StudentRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tata.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
