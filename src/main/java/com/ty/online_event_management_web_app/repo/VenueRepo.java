package com.ty.online_event_management_web_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.online_event_management_web_app.dto.UserOccassion;
import com.ty.online_event_management_web_app.dto.Venue;

public interface VenueRepo extends JpaRepository<Venue, Integer> {

	@Query("select v from Venue v where v.id=?1")
	public Venue getVenueById(String id);
}
