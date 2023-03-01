package com.ty.online_event_management_web_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.online_event_management_web_app.dto.Band;

public interface BandRepo extends JpaRepository<Band, Integer> {

	@Query("select b from Band b where b.id=?1")
	public Band getBandById(String id);
}
