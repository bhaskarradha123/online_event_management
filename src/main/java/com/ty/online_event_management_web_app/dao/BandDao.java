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

	public Band updateBand(Band band, int id) {
		if (repo.findById(id).isPresent()) {
			Band banddb = repo.findById(id).get();
			band.setId(id);
			band.setOrganizer(banddb.getOrganizer());
			return repo.save(band);
		} else {
			return null;
		}
	}

	public Band deleteBand(int id) {
		if (repo.findById(id).isPresent()) {
			Band band = repo.findById(id).get();
			repo.delete(band);
			return band;
		} else {
			return null;
		}
	}

	public Band getBandById(int id) {

		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();

		} else {
			return null;
		}
	}

}
