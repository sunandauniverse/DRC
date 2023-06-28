package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

	@Query(name = "Select count(*) from Teacher Where email=?1 and password=?2", nativeQuery = true)
	public int loginTeacher(String email,String password);
	List<Teacher> findByEmail(String email);
}
