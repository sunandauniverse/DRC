package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Student;
@Service
public interface IStudentService {
	
	Student addStudent(Student s);
	Student searchStudentById(Integer sId);
	String updateStudent(Student student);
	 List<Student> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) ;
	 public boolean findByRollNumber(Integer rollno) ;

}
