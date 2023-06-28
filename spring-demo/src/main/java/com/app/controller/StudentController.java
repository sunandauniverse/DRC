package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	IStudentService service;

	@GetMapping(value = "/add")
	public Student addStudent(@RequestBody Student s) {
		if (s.getRollNo() != -1 && service.findByRollNumber(s.getRollNo())) {
			return service.addStudent(s);
		}
		return null;

	}

	@GetMapping(value = "/{id}")
	public Student findStudentById(@PathVariable Integer sId) {
		return service.searchStudentById(sId);
	}

	@PutMapping(value = "/update")
	public String updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<Student>> getStudents(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
			@RequestParam String sortBy) {
		List<Student> allEmployees = service.getAllEmployees(pageNo, pageSize, sortBy);
		return ResponseEntity.ok(allEmployees);
	}
}
