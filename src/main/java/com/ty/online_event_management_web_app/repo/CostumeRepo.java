package com.ty.online_event_management_web_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.online_event_management_web_app.dto.Costume;


public interface CostumeRepo extends JpaRepository<Costume, Integer>{
	  @Query("select a from Costume a where a.organizer.email=?1")
	     public List<Costume> getCostumeListByOrganizerByEmail(String email);  
	
	
}
