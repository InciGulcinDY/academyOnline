package com.ladinProject.academyOnline.business.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DeleteStudentRequest {
	private Long studentId;
	private String firstname;
	private String lastname;
	private String nationalId;
	private String studentRegistrationNumber;
	private String email;
	private LocalDate dayOfBirth;

}
