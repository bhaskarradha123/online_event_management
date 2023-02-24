package com.ty.online_event_management_web_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ty.online_event_management_web_app.dto.Decoration;

public interface DecorationRepo extends JpaRepository<Decoration, Integer> {
	  @Query("select a from Decoration a where a.organizer.email=?1")
	     public List<Decoration> getDecorationListByOrganizerByEmail(); 
	
}
