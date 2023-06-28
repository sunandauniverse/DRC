package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Student;
@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByRollNo(Integer rollNo);
}
