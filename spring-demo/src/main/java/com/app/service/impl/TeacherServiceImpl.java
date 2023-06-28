package com.app.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Teacher;
import com.app.repository.ITeacherRepository;
import com.app.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService{
	@Autowired
	ITeacherRepository iteacherRepository;

	public Teacher signupTeacher(Teacher t) {
		byte[] encode = Base64.getEncoder().encode(t.getPassword().getBytes());
		t.setPassword(new String(encode));
		return iteacherRepository.save(t);
	}

	public String loginTeacher(String email, String password) {
		byte[] decode = Base64.getDecoder().decode(password);
		String pass = new String(decode);
		int count = iteacherRepository.loginTeacher(email, pass);
		if (count == 1) {
			return "Login Success";
		}
		return "Login Failed";
	}

	public boolean findTeacherByEMail(String email) {
		if (iteacherRepository.findByEmail(email).size() != 0) {
			throw new RuntimeException("teacher already exist with this email");
		} else {

			return true;
		}
	}
}
