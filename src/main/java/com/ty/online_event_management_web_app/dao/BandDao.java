package com.ty.online_event_management_web_app.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Organizer;

import com.ty.online_event_management_web_app.repo.BandRepo;

@Repository
public class BandDao {

	@Autowired
	private BandRepo repo;

	@Autowired
	private OrganizerDao dao;

	public Band saveBand(Band band, String email) {

		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			band.setOrganizer(organizer);
			return repo.save(band);
		} else {
			return null;
		}

	}

	public Band updateBand(Band band, String id) {
		if (repo.getBandById(id)!=null) {
			Band banddb = repo.getBandById(id);
			band.setId(id);
			band.setOrganizer(banddb.getOrganizer());
			return repo.save(band);
		} else {
			return null;
		}
	}

	public Band deleteBand(String id) {
		if (repo.getBandById(id)!=null) {
			Band band = repo.getBandById(id);
			repo.delete(band);
			return band;
		} else {
			return null;
		}
	}

	public Band getBandById(String id) {

		if (repo.getBandById(id)!=null) {
			return repo.getBandById(id);

		} else {
			return null;
		}
	}
	
	
	

}
