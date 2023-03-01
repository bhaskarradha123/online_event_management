package com.ty.online_event_management_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.CustomerDao;
import com.ty.online_event_management_web_app.dao.UserOccasionDao;
import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.User;
import com.ty.online_event_management_web_app.dto.UserOccassion;
import com.ty.online_event_management_web_app.exception.IdNotFoundByUserOccassionException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByUserOccassionServiceException;
import com.ty.online_event_management_web_app.repo.CostumeRepo;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class UserOcassionService {

	@Autowired
	private UserOccasionDao dao;

	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<UserOccassion>> saveUserOccassion(UserOccassion occassion, String email) {

		User user = customerDao.getUserByEmail(email);
		if (user != null) {
			ResponseStructure<UserOccassion> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("UserOccassion Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveOccassion(occassion, email));
			return new ResponseEntity<ResponseStructure<UserOccassion>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementFoundByUserOccassionServiceException();
		}
	}

	public ResponseEntity<ResponseStructure<UserOccassion>> updateUserOcassion(int id, UserOccassion occassion) {
		UserOccassion occassiondb = dao.getOccassionById(id);
		ResponseStructure<UserOccassion> responseStructure = new ResponseStructure<>();
		if (occassiondb != null) {

			responseStructure.setMessage("Sucessfully User Ocassion is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.updateOccasion(occassion, id));
			return new ResponseEntity<ResponseStructure<UserOccassion>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchElementFoundByUserOccassionServiceException();
		}
	}

	public ResponseEntity<ResponseStructure<UserOccassion>> deleteUserOccassion(int id) {
		UserOccassion occassiondb = dao.getOccassionById(id);
		ResponseStructure<UserOccassion> responseStructure = new ResponseStructure<>();
		if (occassiondb != null) {

			responseStructure.setMessage("Sucessfully User Ocassion is Deletd");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.deleteOccassion(id));
			return new ResponseEntity<ResponseStructure<UserOccassion>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchElementFoundByUserOccassionServiceException();
		}
	}

	public ResponseEntity<ResponseStructure<UserOccassion>> getUserOccassionById(int id) {
		UserOccassion occassiondb = dao.getOccassionById(id);
		ResponseStructure<UserOccassion> responseStructure = new ResponseStructure<>();
		if (occassiondb != null) {

			responseStructure.setMessage("Sucessfully User Ocassion is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.getOccassionById(id));
			return new ResponseEntity<ResponseStructure<UserOccassion>>(responseStructure, HttpStatus.OK);
		} else {

			throw new IdNotFoundByUserOccassionException();
		}
	}

	public ResponseEntity<ResponseStructure<List<UserOccassion>>> getListOfUsers(String email) {
		User user = customerDao.getUserByEmail(email);
		ResponseStructure<List<UserOccassion>> responseStructure = new ResponseStructure<>();
		if (user != null) {

			responseStructure.setMessage("Sucessfully User Ocassion is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.getListOccasionByUserEmail(email));
			return new ResponseEntity<ResponseStructure<List<UserOccassion>>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchElementFoundByUserOccassionServiceException();
		}
	}

}
