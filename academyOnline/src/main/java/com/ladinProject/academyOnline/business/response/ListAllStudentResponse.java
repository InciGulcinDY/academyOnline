package com.ladinProject.academyOnline.business.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ListAllStudentResponse {
	private String firstname;
	private String lastname;
	private String nationalId;
	private String studentRegistrationNumber;
	private String email;
	private LocalDate dayOfBirth;
	private int age;

}
