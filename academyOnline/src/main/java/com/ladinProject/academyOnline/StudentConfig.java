package com.ladinProject.academyOnline;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ladinProject.academyOnline.dataAccess.StudentRepository;
import com.ladinProject.academyOnline.entities.concretes.Student;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student sezgin = new Student("Sezgin", "Yolcu", "1246", "sezgin@gmail.com",
					LocalDate.of(1986, Month.JANUARY, 14), 0, null);
			Student doga = new Student("doga", "yolcu", "56214", "doga@gmail.com", LocalDate.of(2018, Month.AUGUST, 31),
					0, "12568");
			
			studentRepository.saveAll(List.of(sezgin , doga));
		};


	}

}