package com.ladinProject.academyOnline.business.abstracts;

import java.util.List;

import com.ladinProject.academyOnline.business.request.DeleteStudentRequest;
import com.ladinProject.academyOnline.business.request.RegisterNewStudentRequest;
import com.ladinProject.academyOnline.business.response.ListAllStudentResponse;


public interface StudentService {
	public List<ListAllStudentResponse> getAll();
	public void registerNewStudent(RegisterNewStudentRequest registerNewStudentRequest);
	public void deleteStudent(DeleteStudentRequest deleteStudentRequest);
	public void updateStudent(Long studentId, String name, String email);

}
