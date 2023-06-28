package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.Teacher;

@Service
public interface ITeacherService {

	public Teacher signupTeacher(Teacher t);
	public String loginTeacher(String email, String password) ;
	public boolean findTeacherByEMail(String email);

}
