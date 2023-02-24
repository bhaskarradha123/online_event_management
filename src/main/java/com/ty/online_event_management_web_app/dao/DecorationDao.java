package com.ty.online_event_management_web_app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.repo.DecorationRepo;
@Repository
public class DecorationDao {
     private DecorationRepo repo;
	 @Autowired
	    private OrganizerDao dao;
		public List<Decoration> saveDecoration(List<Decoration> decoration, String email) {
			Organizer organizer = dao.getOrganizerByEmail(email);
			if (organizer != null) {
				List<Decoration>decoration2=new ArrayList<>();
				for (Decoration m : decoration2) {
					m.setOrganizer(organizer);
					repo.save(m);
				}
				return decoration2;
			} else {
				return null;
			}
		}

		public Decoration UpdateDecoration(Decoration decoration, int id) {

			if (repo.findById(id).isPresent()) {
				decoration.setId(id);
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
				Decoration decoration = repo.findById(id).get();
				return decoration;
			} else {
				return null;
			}
		}

		public List<Decoration> getlistOfDecorationByEmail(String email) {
			List<Decoration> list = repo.getDecorationListByOrganizerByEmail(email);
			return list;
		}

	
}
