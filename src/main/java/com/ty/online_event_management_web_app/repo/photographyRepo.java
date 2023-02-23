package com.ty.online_event_management_web_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.online_event_management_web_app.dto.Photographer;

public interface photographyRepo  extends JpaRepository< Photographer, Integer>{
	
}
