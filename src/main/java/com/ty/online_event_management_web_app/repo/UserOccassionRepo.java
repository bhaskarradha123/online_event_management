package com.ty.online_event_management_web_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.online_event_management_web_app.dto.UserOccassion;

public interface UserOccassionRepo extends JpaRepository<UserOccassion, Integer> {

	@Query("select a from UserOccassion a where a.user.email=?1")
    public List<UserOccassion> getListOfEmail(String email);
	
}
