package com.ty.online_event_management_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.CostumeDao;
import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByCostumeServiceException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class CostumeService {

	@Autowired
	private CostumeDao dao;

	@Autowired
	private OrganizerDao organizerDao;

	@Autowired
	private CostumeDao costumeDao;

	public ResponseEntity<ResponseStructure<List<Costume>>> saveCostume(List<Costume> costume, String email) {

		Organizer organizer = organizerDao.getOrganizerByEmail(email);
		if (organizer != null) {
			ResponseStructure<List<Costume>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Costume Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveCostume(costume, email));
			return new ResponseEntity<ResponseStructure<List<Costume>>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementFoundByCostumeServiceException();
		}
	}

	public ResponseEntity<ResponseStructure<Costume>> updateCostume(Costume costume, int id) {

		Costume costumedb = costumeDao.getCostumeById(id);
		if (costumedb != null) {
			ResponseStructure<Costume> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Costume Is Updated Sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.UpdateCostume(costume, id));
			return new ResponseEntity<ResponseStructure<Costume>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementFoundByCostumeServiceException();
		}
	}

	public ResponseEntity<ResponseStructure<Costume>> deleteCostume(int id) {

		Costume costumedb = costumeDao.getCostumeById(id);
		if (costumedb != null) {
			ResponseStructure<Costume> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Costume Is Deleted Sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.deleteCostume(id));
			return new ResponseEntity<ResponseStructure<Costume>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementFoundByCostumeServiceException();
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Costume>> getCostumeById(int id) {

		Costume costumedb = costumeDao.getCostumeById(id);
		if (costumedb != null) {
			ResponseStructure<Costume> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Costume Is Found   Sucessfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.getCostumeById(id));
			return new ResponseEntity<ResponseStructure<Costume>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new NoSuchElementFoundByCostumeServiceException();
		}
	}
	
	
	

}
