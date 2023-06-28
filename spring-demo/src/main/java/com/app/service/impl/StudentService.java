package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repository.IStudentRepository;
import com.app.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	IStudentRepository repository;

	public Student searchStudentById(Integer sId) {
		Optional<Student> opt = repository.findById(sId);
		if (opt.isPresent()) {
			Student student = opt.get();
			return student;
		}

		return null;
	}

	@Override
	public String updateStudent(Student student) {

		if (repository.existsById(student.getRollNo())) {
			repository.save(student);
			return "the student is updated";
		}
		return "the student is not exist";
	}

	@Override
	public Student addStudent(Student s) {
		if (!repository.existsById(s.getRollNo())) {
			return repository.save(s);
		}else {
			throw new RuntimeException("Student already exist with this roll number");
		}

	}

	public List<Student> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Student> pagedResult = repository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Student>();
		}
	}
   public boolean findByRollNumber(Integer rollno) {
	   List<Student> findByRollNo = repository.findByRollNo(rollno);
	   if(findByRollNo.size()!=0) {
		   throw new RuntimeException("Student roll number already exit");
	   }
        return true;	   
   }
}
