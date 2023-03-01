package com.ty.online_event_management_web_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.repo.photographyRepo;

@Repository
public class PhotographerDao {
	@Autowired
	private photographyRepo repo;

	@Autowired
	private OrganizerDao dao;

	public Photographer savePhotographer(Photographer photographer, String email) {

		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			photographer.setOrganizer(organizer);
			return repo.save(photographer);
		} else {
			return null;
		}

	}

	public Photographer updatePhotographer(Photographer photographer, int id) {
		if (repo.findById(id).isPresent()) {
			Photographer photographerdb = repo.findById(id).get();
			photographer.setId(id);
			photographer.setOrganizer(photographerdb.getOrganizer());
			return repo.save(photographer);
		} else {
			return null;
		}
	}

	public Photographer deleteVenue(int id) {
		if (repo.findById(id).isPresent()) {
			Photographer photographer = repo.findById(id).get();
			repo.delete(photographer);
			return photographer;
		} else {
			return null;
		}
	}

	public Photographer getPhotographerById(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

}
