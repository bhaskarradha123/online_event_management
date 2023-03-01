package com.ty.online_event_management_web_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.dto.Purohith;
import com.ty.online_event_management_web_app.dto.Venue;

public interface OrganizerRepo extends JpaRepository<Organizer, String> {

	public Organizer findByEmail(String email);

	@Query("select o from Organizer o where o.service=?1")
	public List<Organizer> getServiceByOrganizerService(String service);


}
