package com.ty.online_event_management_web_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.repo.DecorationRepo;

@Repository
public class Decorationdao {
	@Autowired
	private DecorationRepo repo;
	@Autowired
	private OrganizerDao dao;

	public List<Decoration> saveDecoration(List<Decoration> decoration, String email) {
		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			for (Decoration m : decoration) {
				m.setOrganizer(organizer);
				repo.save(m);
			}
			return decoration;
		} else {
			return null;
		}
	}

	public Decoration UpdateDecoration(Decoration decoration, int id) {

		if (repo.findById(id).isPresent()) {
			Decoration decorationdb = repo.findById(id).get();
			decoration.setId(id);
			decoration.setOrganizer(decorationdb.getOrganizer());
			return repo.save(decoration);
		} else {
			return null;
		}
	}

	public Decoration deleteDecoration(int id) {

		if (repo.findById(id).isPresent()) {
			Decoration decoration = repo.findById(id).get();
			repo.delete(decoration);
			return decoration;
		} else {
			return null;
		}
	}

	public Decoration getDecorationById(int id) {

		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Decoration> getlistOfDecorationByEmail(String email) {
		List<Decoration> list = repo.getDecorationListByOrganizerByEmail(email);
		return list;
	}

}
