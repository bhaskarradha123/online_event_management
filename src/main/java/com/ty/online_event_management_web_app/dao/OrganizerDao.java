package com.ty.online_event_management_web_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.dto.Purohith;
import com.ty.online_event_management_web_app.dto.Venue;
import com.ty.online_event_management_web_app.repo.OrganizerRepo;

@Repository
public class OrganizerDao {
	@Autowired
	private OrganizerRepo repo;

	public Organizer saveOrganizer(Organizer organizer) {
		return repo.save(organizer);
	}

	public Organizer UpdateOrganizer(Organizer organizer, String email) {
		Organizer organizer2 = repo.findByEmail(email);
		if (organizer2 != null) {
			organizer.setEmail(email);
			repo.save(organizer);
			return organizer;
		} else {
			return null;
		}
	}

	public Organizer deleteOrganizer(String email) {
		Organizer organizer2 = repo.findByEmail(email);
		if (organizer2 != null) {
			repo.delete(organizer2);
			return organizer2;
		} else {
			return null;
		}
	}

	public Organizer getOrganizerByEmail(String email) {
		Organizer organizer = repo.findByEmail(email);
		if (organizer != null) {
			return organizer;
		} else {
			return null;
		}
	}

	public List<Organizer> getListOfServices(String service) {

		List<Organizer> servicedb = repo.getServiceByOrganizerService(service);

		return servicedb;
	}

}
