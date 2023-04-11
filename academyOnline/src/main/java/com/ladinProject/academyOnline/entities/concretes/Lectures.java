package com.ladinProject.academyOnline.entities.concretes;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lecture_List")

public class Lectures {
	@Id
	@SequenceGenerator(name = "lecture_id_generator", sequenceName = "lecture_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_id_generator")
	private Long lectureId;
	
	private String lecture;
	
	private String lectureCode; 

	@ManyToMany(mappedBy = "lectureCapabilities" , cascade = CascadeType.ALL)
	private Set<Teacher> teachers;
}
