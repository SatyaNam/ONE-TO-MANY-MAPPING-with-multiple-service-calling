package com.quest.springboot.offer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quest.springboot.offer.entity.OfferDetailsEntity;

@Repository
public interface OfferDetailsRepository extends CrudRepository<OfferDetailsEntity, Integer> {

	public OfferDetailsEntity findByState(String state);

}