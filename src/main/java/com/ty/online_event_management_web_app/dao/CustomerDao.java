package com.ty.online_event_management_web_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.*;
import com.ty.online_event_management_web_app.repo.UserRepo;

@Repository
public class CustomerDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User UpdateUser(User user, String email) {
		User userdb = repo.findByEmail(email);
		if (userdb != null) {
			user.setEmail(email);
			repo.save(user);
			return user;
		} else {
			return null;
		}
	}

	public User deleteUser(String email) {
		User user = repo.findByEmail(email);
		if (user != null) {
			repo.delete(user);
			return user;
		} else {
			return null;
		}
	}

	public User getUserByEmail(String email) {
		User user = repo.findByEmail(email);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
	
	
}
