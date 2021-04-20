package com.quest.springboot.offer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.springboot.offer.dto.StudentDetailsDto;
import com.quest.springboot.offer.entity.OfferDetailsEntity;
import com.quest.springboot.offer.service.OfferDetailsService;

@RestController
@RequestMapping("off/api/v3")
public class OfferDetailsController {
	@Autowired
	private OfferDetailsService offerDetailsService;

	@PostMapping("save/json")
	public OfferDetailsEntity createAddressDetails(@RequestBody OfferDetailsEntity offerDetailsEntity) {
		return offerDetailsService.createOffer(offerDetailsEntity);

	}

	@GetMapping("/offer/json/{state}")
	public StudentDetailsDto getOfferAvailableByState(@PathVariable String state) {
		OfferDetailsEntity  offerDetailsEntity= offerDetailsService.getOfferAvailableByState(state);
		StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
		studentDetailsDto.setOfferPercent(offerDetailsEntity.getOffer());
		studentDetailsDto.setState(offerDetailsEntity.getState());
		return studentDetailsDto;

	}
}
