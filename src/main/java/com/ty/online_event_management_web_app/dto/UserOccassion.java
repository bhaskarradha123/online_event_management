package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Data
public class UserOccassion {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userOccassion_seq")
//	@GenericGenerator(name = "userOccassion_seq", strategy = "com.ty.online_event_management_web_app.dto.CustomIdIdGenerator", parameters = {
//			@Parameter(name = CustomIdIdGenerator.INCREMENT_PARAM, value = "50"),
//			@Parameter(name = CustomIdIdGenerator.VALUE_PREFIX_PARAMETER, value = "userOccassion_"),
//			@Parameter(name = CustomIdIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
//	private String id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String relation;
	private String starttime;
	private String startdate;
	private String endtime;
	private String enddate;
	private String occasion;

	@ManyToOne
	private User user;

}
