package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
