package com.ty.online_event_management_web_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Venue;
import com.ty.online_event_management_web_app.repo.VenueRepo;

@Repository
public class VenueDao {

	@Autowired
	private VenueRepo repo;

	@Autowired
	private OrganizerDao dao;

	public Venue saveVenue(Venue venue, String email) {

		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			venue.setOrganizer(organizer);
			return repo.save(venue);
		} else {
			return null;
		}

	}

	public Venue updateVenue(Venue venue, String id) {
		if (repo.getVenueById(id)!=null) {
			Venue venuedb = repo.getVenueById(id);
			venue.setOrganizer(venuedb.getOrganizer());
			venue.setId(id);
			return repo.save(venue);
		} else {
			return null;
		}
	}

	public Venue deleteVenue(String id) {
		if (repo.getVenueById(id)!=null) {
			Venue venue = repo.getVenueById(id);
			repo.delete(venue);
			return venue;
		} else {
			return null;
		}
	}

	public Venue getVenueById(String id) {

		if (repo.getVenueById(id)!=null) {
			Venue venue = repo.getVenueById(id);
			return venue;
		} else {
			return null;
		}
	}

}
