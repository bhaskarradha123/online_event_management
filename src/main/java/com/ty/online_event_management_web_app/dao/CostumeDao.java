package com.ty.online_event_management_web_app.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.repo.CostumeRepo;

@Repository
public class CostumeDao {

	@Autowired
	private CostumeRepo repo;

	@Autowired
	private OrganizerDao dao;

	public List<Costume> saveCostume(List<Costume> costume, String email) {
		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			for (Costume c : costume) {
				c.setOrganizer(organizer);
				repo.save(c);
			}
			return costume;
		} else {
			return null;
		}
	}

	public Costume UpdateCostume(Costume costume, String id) {

		if (repo.getCostumeById(id)!=null) {
			Costume costumedb = repo.getCostumeById(id);
			costume.setId(id);
			costume.setOrganizer(costumedb.getOrganizer());
			return repo.save(costume);
		} else {
			return null;
		}
	}

	public Costume deleteCostume(String id) {

		if (repo.getCostumeById(id)!=null) {
			Costume costume = repo.getCostumeById(id);
			repo.delete(costume);
			return costume;
		} else {
			return null;
		}
	}

	public Costume getCostumeById(String id) {

		if (repo.getCostumeById(id)!=null) {
			return repo.getCostumeById(id);

		} else {
			return null;
		}
	}

	public List<Costume> getCostumeByEmail(String email) {
		List<Costume> list = repo.getCostumeListByOrganizerByEmail(email);
		return list;
	}

}
