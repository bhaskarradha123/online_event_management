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

	public Photographer updatePhotographer(Photographer photographer, String id) {
		if (repo.getPhotographerById(id)!=null) {
			Photographer photographerdb = repo.getPhotographerById(id);
			photographer.setId(id);
			photographer.setOrganizer(photographerdb.getOrganizer());
			return repo.save(photographer);
		} else {
			return null;
		}
	}

	public Photographer deleteVenue(String id) {
		if (repo.getPhotographerById(id)!=null) {
			Photographer photographer = repo.getPhotographerById(id);
			repo.delete(photographer);
			return photographer;
		} else {
			return null;
		}
	}

	public Photographer getPhotographerById(String id) {
		if (repo.getPhotographerById(id)!=null) {
			return repo.getPhotographerById(id);
		} else {
			return null;
		}
	}

}
