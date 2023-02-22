package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Decoration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String design_type;
	private String design_name;
	private double price;

	@ManyToOne
	private Organizer organizer;

}