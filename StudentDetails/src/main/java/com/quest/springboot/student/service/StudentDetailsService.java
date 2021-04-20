package com.quest.springboot.student.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quest.springboot.student.dto.StudentDetailsDto;
import com.quest.springboot.student.entity.AddressDetailsEntity;
import com.quest.springboot.student.entity.StudentDetailsEntity;
import com.quest.springboot.student.repository.StudentDetailsRepository;

@Component
@Service
public class StudentDetailsService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;
	@Autowired
	private RestTemplate restTemplate;

	public StudentDetailsEntity studRegistration(StudentDetailsEntity studentDetailsEntity) {
		return studentDetailsRepository.save(studentDetailsEntity);
	}

	public StudentDetailsEntity getStudById(Integer id) {
		return studentDetailsRepository.findById(id).orElse(null);
	}

	public Iterable<StudentDetailsEntity> getAllStudent() {
		return studentDetailsRepository.findAll();
	}

	public StudentDetailsEntity updateStudent(StudentDetailsEntity studentDetailsEntity) {

		StudentDetailsEntity existingStudentDetailsEntity = studentDetailsRepository
				.findById(studentDetailsEntity.getStudId()).orElse(null);
		
		existingStudentDetailsEntity.setStudName(studentDetailsEntity.getStudName());
	//	existingStudentDetailsEntity.setStudAdd(studentDetailsEntity.getStudAdd());
		existingStudentDetailsEntity.setStudClass(studentDetailsEntity.getStudClass());
		existingStudentDetailsEntity.setStudEmail(studentDetailsEntity.getStudEmail());

		return studentDetailsRepository.save(existingStudentDetailsEntity);
	}
	
	public List<StudentDetailsDto> getOfferAvailable(List<AddressDetailsEntity> addressDetailsEntity){
		
		List<StudentDetailsDto> offerList = new ArrayList<>();
		for(AddressDetailsEntity addressDetails : addressDetailsEntity) {
			final String uri = "http://localhost:8082/off/api/v3/offer/json/"+addressDetails.getState(); 
			StudentDetailsDto studentDetailsDto = restTemplate.getForObject(uri, StudentDetailsDto.class);
			offerList.add(studentDetailsDto);
		}
		
		return offerList;
	}

}
