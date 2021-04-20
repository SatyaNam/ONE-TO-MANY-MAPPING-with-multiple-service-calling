package com.quest.springboot.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.springboot.student.dto.StudentDetailsDto;
import com.quest.springboot.student.entity.AddressDetailsEntity;
import com.quest.springboot.student.entity.StudentDetailsEntity;
import com.quest.springboot.student.service.StudentDetailsService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
//@CrossOrigin("*")
@RequestMapping("stu/api/v1")
public class StudentDetailsController {
	private static final Logger logger = LogManager.getLogger(StudentDetailsController.class);
	@Autowired
	private StudentDetailsService studentDetailsService;

	@PostMapping("/save/json")
	public StudentDetailsEntity createStudentDetails(
			@RequestBody StudentDetailsEntity studentDetailsEntity) {
		
		return studentDetailsService.studRegistration(studentDetailsEntity);

	}

	@GetMapping("/student/{id}/json")
	public StudentDetailsEntity getStudentDetailsById(
			@PathVariable Integer id) {
		return studentDetailsService.getStudById(id);

	}

	@GetMapping("/students/json")
	public Iterable<StudentDetailsEntity> getAllStudentDetails() {
		return studentDetailsService.getAllStudent();

	}
  
	@PutMapping("update/json")
	public StudentDetailsEntity updateStudentDetails(
			@RequestBody StudentDetailsEntity studentDetailsEntity) {
		return studentDetailsService.updateStudent(studentDetailsEntity);

	}
	
	@GetMapping("/getStudentOffer/json/{id}")
	public StudentDetailsEntity getStudentOffer(@PathVariable("id") Integer id) {
		StudentDetailsEntity std = studentDetailsService.getStudById(id);
		
		List<AddressDetailsEntity> addressDetailsEntity = std.getAddressEntity();
		
		List<StudentDetailsDto> studentDetailsDto = studentDetailsService.getOfferAvailable(addressDetailsEntity);
		
		//print studentDetailsDto in log.
		logger.info("Stduent offer based on id :"+std.getStudId()+" offer "+studentDetailsDto);
		
		return std;
	}

}