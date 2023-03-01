package com.ty.online_event_management_web_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Organizer;

import com.ty.online_event_management_web_app.repo.MakeUpRepo;

@Repository
public class MakeUpDao {

	@Autowired
	private MakeUpRepo repo;

	@Autowired
	private OrganizerDao dao;

	public MakeUp saveMakeUp(MakeUp makeUp, String email) {

		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			makeUp.setOrganizer(organizer);
			return repo.save(makeUp);
		} else {
			return null;
		}

	}

	public MakeUp updateMakeUp(MakeUp makeUp, int id) {
		if (repo.findById(id).isPresent()) {
			MakeUp makeUpdb = repo.findById(id).get();
			makeUp.setId(id);
			makeUp.setOrganizer(makeUpdb.getOrganizer());
			return repo.save(makeUp);
		} else {
			return null;
		}
	}

	public MakeUp deleteMakeUp(int id) {
		if (repo.findById(id).isPresent()) {
			MakeUp makeUp = repo.findById(id).get();
			repo.delete(makeUp);
			return makeUp;
		} else {
			return null;
		}
	}

	public MakeUp getMakeUpById(int id) {

		if (repo.findById(id).isPresent()) {

			return repo.findById(id).get();
		} else {
			return null;
		}
	}

}
