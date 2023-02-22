package com.ty.online_event_management_web_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class UserOccassion {
   
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
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
