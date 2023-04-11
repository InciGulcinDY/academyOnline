package com.ladinProject.academyOnline.webApiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladinProject.academyOnline.business.abstracts.StudentService;
import com.ladinProject.academyOnline.business.request.RegisterNewStudentRequest;
import com.ladinProject.academyOnline.business.response.ListAllStudentResponse;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/listallstudent")
	public List<ListAllStudentResponse> getAll() {

		return studentService.getAll();
	}

	@PostMapping
	public void registerNewStudent(@RequestBody RegisterNewStudentRequest registerNewStudent) {
		studentService.registerNewStudent(registerNewStudent);
	}

	@DeleteMapping(path = "{/studentRegistrationNumber}")
	public void deleteStudent(@PathVariable("studentRegistrationNumber") String studentRegistrationNumber) {
		studentService.deleteStudent(null);

	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {

		
	}

}
