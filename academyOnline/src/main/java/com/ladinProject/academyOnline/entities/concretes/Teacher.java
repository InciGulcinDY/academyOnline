package com.ladinProject.academyOnline.entities.concretes;

import java.util.List;

import com.ladinProject.academyOnline.entities.abstracts.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_list")
	
public class Teacher extends Person {
	@Id
	@SequenceGenerator(name = "teacher_id_generator", sequenceName = "teacher_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_generator")
	private Long teacherId;

	private String teacherRegistrationNumber;

	@ManyToMany
	private List<Lectures> lectureCapabilities;

}
