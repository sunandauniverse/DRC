package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Teacher;
import com.app.service.ITeacherService;

import jakarta.validation.Valid;

@RestController
public class TeacherController {
	@Autowired
	private ITeacherService iTeacherService;

	@PostMapping("/signupTeacher")
	public ResponseEntity<Teacher> signUpTeacher(@Valid @RequestBody Teacher t) {
		if (!iTeacherService.findTeacherByEMail(t.getEmail())) {
			Teacher teacher = iTeacherService.signupTeacher(t);
			return ResponseEntity.ok(teacher);
		}
		return ResponseEntity.badRequest().build();

	}

	@PostMapping("/loginTeacher")
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String pass) {
		String login = iTeacherService.loginTeacher(email, pass);
		return ResponseEntity.ok(login);
	}
}
