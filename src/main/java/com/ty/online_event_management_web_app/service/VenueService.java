package com.ty.online_event_management_web_app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dao.VenueDao;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Venue;
import com.ty.online_event_management_web_app.exception.IdNotFoundByBandException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByVenueServiceException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class VenueService {
	@Autowired
	private VenueDao dao;
	@Autowired
	private OrganizerDao organizerdao;

	public ResponseEntity<ResponseStructure<Venue>> saveVenue(Venue venue, String email) {

		Organizer organizer = organizerdao.getOrganizerByEmail(email);
		if (organizer != null) {
			ResponseStructure<Venue> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("User Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveVenue(venue, email));
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.CREATED);
		} else
			throw new NoSuchElementFoundByOrganizerException(
					"Organizer is not found for given email " + email + " to save venue");
	}

	public ResponseEntity<ResponseStructure<Venue>> updateVenue(int id, Venue venue) {
		Venue venuedb = dao.updateVenue(venue, id);
		ResponseStructure<Venue> responseStructure = new ResponseStructure<>();
		if (venuedb != null) {

			responseStructure.setMessage("Sucessfully Venue is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(venue);
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByBandException("Venue is not found for your id " + id + " to update");

		}
	}

	public ResponseEntity<ResponseStructure<Venue>> deleteVenue(int id) {
		Venue venuedb = dao.deleteVenue(id);
		ResponseStructure<Venue> responseStructure = new ResponseStructure<>();
		if (venuedb != null) {

			responseStructure.setMessage("Sucessfully Venue is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(venuedb);
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByBandException("Venue is not found for your id " + id + " to delete");

		}
	}

	public ResponseEntity<ResponseStructure<Venue>> getVenueById(int id) {
		Venue venuedb = dao.getVenueById(id);
		ResponseStructure<Venue> responseStructure = new ResponseStructure<>();
		if (venuedb != null) {

			responseStructure.setMessage("Sucessfully Venue  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(venuedb);
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByVenueServiceException("Venue is not found for your id " + id + " to display");
		}

	}

}
