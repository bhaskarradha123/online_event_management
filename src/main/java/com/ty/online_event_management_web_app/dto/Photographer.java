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
public class Photographer {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photographer_seq")
//	@GenericGenerator(name = "photographer_seq", strategy = "com.ty.online_event_management_web_app.dto.CustomIdIdGenerator", parameters = {
//			@Parameter(name = CustomIdIdGenerator.INCREMENT_PARAM, value = "50"),
//			@Parameter(name = CustomIdIdGenerator.VALUE_PREFIX_PARAMETER, value = "photographer_"),
//			@Parameter(name = CustomIdIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
//	private String id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String camera;
	private double fees;
	private String door_no;
	private String street;
	private String location;

	@OneToOne
	private Organizer organizer;
}
