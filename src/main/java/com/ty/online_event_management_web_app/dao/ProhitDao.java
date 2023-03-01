package com.ty.online_event_management_web_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Purohith;
import com.ty.online_event_management_web_app.repo.PurohitRepo;

@Repository
public class ProhitDao {
	@Autowired
	private PurohitRepo repo;

	@Autowired
	private OrganizerDao dao;

	public Purohith saveProhith(Purohith purohith, String email) {

		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			purohith.setOrganizer(organizer);
			return repo.save(purohith);
		} else {
			return null;
		}

	}

//	public Purohith updatePurohith(Purohith purohith, String id) {
//		if (repo.findBy(id).isPresent()) {
//			Purohith purohithdb = repo.findById(id).get();
//			purohith.setId(id);
//			purohith.setOrganizer(purohithdb.getOrganizer());
//			return repo.save(purohith);
//		} else {
//			return null;
//		}
//	}
//
//	public Purohith deletePurohith(int id) {
//		if (repo.findById(id).isPresent()) {
//			Purohith purohith = repo.findById(id).get();
//			repo.delete(purohith);
//			return purohith;
//		} else {
//			return null;
//		}
//	}
//
//	public Purohith getPurohithById(int id) {
//		if (repo.findById(id).isPresent()) {
//			return repo.findById(id).get();
//		} else {
//			return null;
//		}
//	}

}
