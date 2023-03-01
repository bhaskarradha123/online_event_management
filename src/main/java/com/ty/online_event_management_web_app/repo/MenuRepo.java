package com.ty.online_event_management_web_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.online_event_management_web_app.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

	@Query("select a from Menu a where a.organizer.email=?1")
	public List<Menu> getMenuListByOrganizerEmail(String email);

}
