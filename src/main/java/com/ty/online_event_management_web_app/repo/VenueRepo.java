package com.ty.online_event_management_web_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.online_event_management_web_app.dto.Venue;

public interface VenueRepo extends JpaRepository<Venue, Integer> {

}
