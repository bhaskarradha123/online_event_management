package com.ty.online_event_management_web_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.online_event_management_web_app.dto.User;
import com.ty.online_event_management_web_app.dto.UserOccassion;
import com.ty.online_event_management_web_app.repo.UserOccassionRepo;

@Repository
public class UserOccasionDao {

	@Autowired
	private UserOccassionRepo repo;

	@Autowired
	private CustomerDao dao;;

	public UserOccassion saveOccassion(UserOccassion occassion, String email) {

		User user = dao.getUserByEmail(email);
		if (user != null) {
			occassion.setUser(user);
			return repo.save(occassion);
		} else {
			return null;
		}

	}

	public UserOccassion updateOccasion(UserOccassion occassion, int id) {
		if (repo.findById(id).isPresent()) {
			UserOccassion occassiondb = repo.findById(id).get();
			occassion.setId(id);
			occassion.setUser(occassiondb.getUser());
			return repo.save(occassion);
		} else {
			return null;
		}
	}

	public UserOccassion deleteOccassion(int id) {
		if (repo.findById(id).isPresent()) {
			UserOccassion occassion = repo.findById(id).get();
			repo.delete(occassion);
			return occassion;
		} else {
			return null;
		}
	}

	public UserOccassion getOccassionById(int id) {

		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<UserOccassion> getListOccasionByUserEmail(String email) {

		List<UserOccassion> list = repo.getListOfEmail(email);
		return list;
	}

}
