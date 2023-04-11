package com.ladinProject.academyOnline.entities.concretes;

import java.time.LocalDate;

import com.ladinProject.academyOnline.entities.abstracts.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Student")

@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
	@Id
	@SequenceGenerator(name = "student_id_generator", sequenceName = "student_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
	@Getter
	private long studentId;

	@Getter
	@Setter
	private String studentRegistrationNumber;

	// Constructor
	public Student(String firstname, String lastname, String nationalId, String email, LocalDate dayOfBirth, int age,
			String studentRegistrationNumber) {
		super(firstname, lastname, nationalId, email, dayOfBirth, age);
		this.studentRegistrationNumber = studentRegistrationNumber;
	}

}
