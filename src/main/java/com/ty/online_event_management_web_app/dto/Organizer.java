package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Organizer {

	@Id
	private String email;
	private String first_name;
	private String last_name;
	private int age;
	private String gender;
	private String password;
	private String phone;
	private String address;
	private String service;

	
}
