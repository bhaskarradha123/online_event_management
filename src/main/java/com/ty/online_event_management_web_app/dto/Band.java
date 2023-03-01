package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Band {

	@Id
	private int id;
	@NotNull(message = "The band Name Should not be null")
	private String band_name;
	@NotBlank(message = "The Band size is Mandatory ")
	private String band_size;
	@NotEmpty(message = "The Band Style is Mandatory ")
	private String band_style;
	@NotEmpty(message = "The Band Fees is Mandatory ")
	private double fees;

	@OneToOne
	private Organizer organizer;

}
