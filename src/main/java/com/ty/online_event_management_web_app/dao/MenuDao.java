package com.ty.online_event_management_web_app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.repo.MenuRepo;

@Repository
public class MenuDao {
    @Autowired
	private MenuRepo repo;
    @Autowired
    private OrganizerDao dao;
	public List<Menu> saveMenu(List<Menu> menu, String email) {
		Organizer organizer = dao.getOrganizerByEmail(email);
		if (organizer != null) {
			List<Menu>menu2=new ArrayList<>();
			for (Menu m : menu) {
				m.setOrganizer(organizer);
				repo.save(m);
			}
			return menu2;
		} else {
			return null;
		}
	}

	public Menu UpdateMenu(Menu menu, int id) {

		if (repo.findById(id).isPresent()) {
			menu.setId(id);
			return repo.save(menu);
		} else {
			return null;
		}
	}

	public Menu deleteMenu(int id) {

		if (repo.findById(id).isPresent()) {
			Menu menu = repo.findById(id).get();
			repo.delete(menu);
			return menu;
		} else {
			return null;
		}
	}

	public Menu getMenuById(int id) {

		if (repo.findById(id).isPresent()) {
			Menu menu = repo.findById(id).get();
			return menu;
		} else {
			return null;
		}
	}

	public List<Menu> getlistOfMenuByEmail(String email) {
		List<Menu> list = repo.getMenuListByOrganizerEmail(email);
		return list;
	}

}
