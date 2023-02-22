package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String venue_name;
	private String address;
	private String rent_per_day;
	private int venue_capacity;
	
	@ManyToOne
	private Organizer organizer;
}
