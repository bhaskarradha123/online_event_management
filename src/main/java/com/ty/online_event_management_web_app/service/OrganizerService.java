package com.ty.online_event_management_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.OrganizerDao;

import com.ty.online_event_management_web_app.dto.Organizer;

import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerLoginException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerSignUpException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByPurohithServiceException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class OrganizerService {  
	@Autowired
	private OrganizerDao dao;

	public ResponseEntity<ResponseStructure<Organizer>> saveOrganizer(Organizer organizer ,String email) {
		Organizer organizerdb = dao.getOrganizerByEmail(email);
		ResponseStructure<Organizer> responseStructure = new ResponseStructure<>();
		if (organizerdb == null) {
         organizer.setEmail(email);
		responseStructure.setMessage("Organizer Is Signup Sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveOrganizer(organizer));
		return new ResponseEntity<ResponseStructure<Organizer>>(responseStructure, HttpStatus.CREATED);
		}
		throw new NoSuchElementFoundByOrganizerSignUpException(
				"Organizer is  found for your email " + email + " to u cant signup pls provide another email");
	}

	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(String email, Organizer organizer) {
		Organizer organizerdb = dao.UpdateOrganizer(organizer, email);
		ResponseStructure<Organizer> responseStructure = new ResponseStructure<>();
		if (organizerdb != null) {

			responseStructure.setMessage("Sucessfully Organizer is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(organizerdb);
			return new ResponseEntity<ResponseStructure<Organizer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByOrganizerException(
					"Organizer is not found for your email " + email + " to update");
		}
	}

	public ResponseEntity<ResponseStructure<Organizer>> deleteOrganizer(String email) {
		Organizer organizerdb = dao.deleteOrganizer(email);
		ResponseStructure<Organizer> responseStructure = new ResponseStructure<>();
		if (organizerdb != null) {

			responseStructure.setMessage("Sucessfully Organizer is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(organizerdb);
			return new ResponseEntity<ResponseStructure<Organizer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByOrganizerException(
					"Organizer is not found for your email " + email + " to delete");
		}
	}

	
	public ResponseEntity<ResponseStructure<Organizer>> loginOrganizer(String email,String pwd) {
		Organizer organizerdb = dao.getOrganizerByEmail(email);
		ResponseStructure<Organizer> responseStructure = new ResponseStructure<>();
		if (organizerdb != null) {

			if(organizerdb.getPassword().equals(pwd)) {
				responseStructure.setMessage("Sucessfully  Organizer Loggedin  ");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(organizerdb);
				return new ResponseEntity<ResponseStructure<Organizer>>(responseStructure, HttpStatus.OK);
			}
			else {
				throw new NoSuchElementFoundByOrganizerLoginException(
						"pls check the password "+pwd+" properly");
			}
		} else {
			throw new NoSuchElementFoundByOrganizerException(
					"Organizer is not found for your email " + email + " to to login");
		}
	}

	
	
	
	public ResponseEntity<ResponseStructure<Organizer>> getByEmail(String email) {
		Organizer organizerdb = dao.getOrganizerByEmail(email);
		ResponseStructure<Organizer> responseStructure = new ResponseStructure<>();
		if (organizerdb != null) {

			responseStructure.setMessage("Sucessfully Organizer  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(organizerdb);
			return new ResponseEntity<ResponseStructure<Organizer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByOrganizerException(
					"Organizer is not found for your email " + email + " to display");
		}
	}


	public ResponseEntity<ResponseStructure<List<Organizer>>> getListOfService(String service) {
		List<Organizer> list = dao.getListOfService(service);
		ResponseStructure<List<Organizer>> responseStructure = new ResponseStructure<>();
		if (list != null) {

			responseStructure.setMessage("Sucessfully service " + service + " is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Organizer>>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchElementFoundByPurohithServiceException(service + " service is not found");
		}

	}

	
	
	
	

}
