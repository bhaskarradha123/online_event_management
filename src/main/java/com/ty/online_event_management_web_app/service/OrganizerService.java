package com.ty.online_event_management_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.dto.Purohith;
import com.ty.online_event_management_web_app.dto.Venue;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByBandServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByCostumeServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByDecorationServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByMakeUpServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByMenuServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByPhotographerServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByPurohithServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByVenuexception;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class OrganizerService {
	@Autowired
	private OrganizerDao dao;

	public ResponseEntity<ResponseStructure<Organizer>> saveOrganizer(Organizer organizer) {
		ResponseStructure<Organizer> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Organizer Is Saved Sucessfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveOrganizer(organizer));
		return new ResponseEntity<ResponseStructure<Organizer>>(responseStructure, HttpStatus.CREATED);
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

	public ResponseEntity<ResponseStructure<List<Organizer>>> getListOfServices(String service) {
		List<Organizer> list = dao.getListOfServices(service);
		ResponseStructure<List<Organizer>> responseStructure = new ResponseStructure<>();
		if (list != null) {

			responseStructure.setMessage("Sucessfully service " + service + " is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Organizer>>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchElementFoundByBandServiceException(service + " service is not found");
		}

	}
}
