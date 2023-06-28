package com.app.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollNo=-1;

	@NotBlank(message = "name cannot be blank")
	private String name;
	
	

	private String department;
	private String stanard;
	private String gender;

	@Min(value = 18, message = "age should not less than 18")
	private Integer age;

}
