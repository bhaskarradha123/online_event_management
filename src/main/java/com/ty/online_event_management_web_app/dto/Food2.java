package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Food2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item_name;
	private String style;
	private double price;
	private int count;
	
	@ManyToOne
	private UserOccassion occassion;
	
	
}
