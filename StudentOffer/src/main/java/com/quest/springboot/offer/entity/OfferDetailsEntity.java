package com.quest.springboot.offer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Offer")
public class OfferDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "OFFERID")
	private Integer offerId;
	
	@Column(name = "OFFER")
	private Integer offer;

	@Column(name = "STATE")
	private String state;

}
