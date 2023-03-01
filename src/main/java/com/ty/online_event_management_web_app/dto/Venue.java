package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venue_seq")
	@GenericGenerator(name = "venue_seq", strategy = "com.ty.online_event_management_web_app.dto.CustomIdIdGenerator", parameters = {
			@Parameter(name = CustomIdIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdIdGenerator.VALUE_PREFIX_PARAMETER, value = "venue_"),
			@Parameter(name = CustomIdIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;

	private String venue_name;
	private String building_no;
	private String street;
	private String location;
	private String district;
	private String state;
	private int pincode;
	private String rent_per_day;
	private int venue_capacity;

	@OneToOne
	private Organizer organizer;
}
