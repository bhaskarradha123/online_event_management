package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Band {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String band_name;
	private String band_size;
	private String band_style;
	private double fees;

	@OneToOne
	private Organizer organizer;

}
