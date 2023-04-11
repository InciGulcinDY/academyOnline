package com.ladinProject.academyOnline.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladinProject.academyOnline.business.abstracts.StudentService;
import com.ladinProject.academyOnline.business.request.DeleteStudentRequest;
import com.ladinProject.academyOnline.business.request.RegisterNewStudentRequest;
import com.ladinProject.academyOnline.business.response.ListAllStudentResponse;
import com.ladinProject.academyOnline.dataAccess.StudentRepository;
import com.ladinProject.academyOnline.entities.concretes.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentManager implements StudentService {
	private StudentRepository studentRepository;
	// private ListAllStudentResponse responseItem;

	@Autowired
	public StudentManager(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<ListAllStudentResponse> getAll() {
		// TODO Auto-generated method stub

		List<Student> students = studentRepository.findAll();
		ArrayList<ListAllStudentResponse> listAllStudentResponses = new ArrayList<ListAllStudentResponse>();

		for (Student student : students) {
			ListAllStudentResponse responseItem = new ListAllStudentResponse();
			responseItem.setFirstname(student.getFirstname());
			responseItem.setLastname(student.getLastname());
			responseItem.setEmail(student.getEmail());
			responseItem.setNationalId(student.getNationalId());
			responseItem.setStudentRegistrationNumber(student.getStudentRegistrationNumber());
			responseItem.setDayOfBirth(student.getDayOfBirth());
			responseItem.setAge(student.getAge());

			listAllStudentResponses.add(responseItem);

		}

		return listAllStudentResponses;
	}

	@Override
	public void registerNewStudent(RegisterNewStudentRequest registerNewStudentRequest) {

		// Before registration, check the email if it exists in the database
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(registerNewStudentRequest.getEmail());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}

		// Transferring data from Request API to database
		Student student = new Student();

		student.setFirstname(registerNewStudentRequest.getFirstname());
		student.setLastname(registerNewStudentRequest.getLastname());
		student.setNationalId(registerNewStudentRequest.getNationalId());
		student.setDayOfBirth(registerNewStudentRequest.getDayOfBirth());
		student.setStudentRegistrationNumber(registerNewStudentRequest.getStudentRegistrationNumber());
		student.setEmail(registerNewStudentRequest.getEmail());

		// Save
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(DeleteStudentRequest deleteStudentRequest) {

		// Find the studentRegistrationNumber came from API in the database
		List<Student> students = studentRepository.findAll();

		for (Student student : students) {
			if (student.getStudentRegistrationNumber().equals(deleteStudentRequest.getStudentRegistrationNumber())) {
				deleteStudentRequest.setStudentId(student.getStudentId());
			}
		}

		// Check whether there is the relevant studentRegistrationNumber in the database
		boolean exists = studentRepository.existsById(deleteStudentRequest.getStudentId());

		if (!exists) {
			throw new IllegalStateException("student registration number "
					+ deleteStudentRequest.getStudentRegistrationNumber() + "does not exist");
		}

		// Delete the relevant student via found studentId
		studentRepository.deleteById(deleteStudentRequest.getStudentId());

	}

	@Override
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		// TODO Auto-generated method stub
		
	}

}
