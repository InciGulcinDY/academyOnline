package com.ladinProject.academyOnline.business.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterNewStudentRequest {
	
	private String firstname;
	private String lastname;
	private String nationalId;
	private String studentRegistrationNumber;
	private String email;
	private LocalDate dayOfBirth;
		
}
