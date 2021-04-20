package com.quest.springboot.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quest.springboot.student.entity.AddressDetailsEntity;

@Repository
public interface AddressDetailsRepository extends CrudRepository<AddressDetailsEntity, Integer> {



}
