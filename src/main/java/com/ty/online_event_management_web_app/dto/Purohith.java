package com.ty.online_event_management_web_app.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Purohith {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purohith_seq")
	@GenericGenerator(name = "purohith_seq", strategy = "com.ty.online_event_management_web_app.dto.CustomIdIdGenerator", parameters = {
			@Parameter(name = CustomIdIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdIdGenerator.VALUE_PREFIX_PARAMETER, value = "purohith_"),
			@Parameter(name = CustomIdIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;

	private String name;
	private String occasion;
	private String fees;
	private String door_no;
	private String street;
	private String location;

	@OneToOne
	private Organizer organizer;
}
