package com.ladinProject.academyOnline.entities.abstracts;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass

@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

	@Getter
	@Setter
	private String firstname;

	@Getter
	@Setter
	private String lastname;

	@Getter
	@Setter
	private String nationalId;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private LocalDate dayOfBirth;

	@Transient
	private int age;

	// Getter function for "Age"
	public int getAge() {
		return Period.between(this.dayOfBirth, LocalDate.now()).getYears();
	}

}
