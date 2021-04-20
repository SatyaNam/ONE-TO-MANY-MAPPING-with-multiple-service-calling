package com.quest.springboot.offer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.quest.springboot.offer.entity.OfferDetailsEntity;
import com.quest.springboot.offer.repository.OfferDetailsRepository;

@Component
@Service
public class OfferDetailsService {

	@Autowired
	private OfferDetailsRepository offerDetailsRepository;

	public OfferDetailsEntity createOffer(OfferDetailsEntity offerDetailsEntity) {
		return offerDetailsRepository.save(offerDetailsEntity);
	}

	public OfferDetailsEntity getOfferAvailableByState(String state) {
		return offerDetailsRepository.findByState(state);
	}
}
