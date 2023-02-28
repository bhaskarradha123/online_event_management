package com.ty.online_event_management_web_app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.MakeUpDao;
import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.exception.IdNotFoundByMakeUpException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByMakeUpServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class MakeUpService {
	@Autowired
	private MakeUpDao dao;

	@Autowired
	private OrganizerDao organizerdao;

	public ResponseEntity<ResponseStructure<MakeUp>> saveMakeUp(MakeUp makeUp, String email) {
		Organizer organizer = organizerdao.getOrganizerByEmail(email);
		if (organizer != null) {
			ResponseStructure<MakeUp> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("MakeUp Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveMakeUp(makeUp, email));
			return new ResponseEntity<ResponseStructure<MakeUp>>(responseStructure, HttpStatus.CREATED);
		}
		throw new NoSuchElementFoundByOrganizerException(
				"Organizer is not found for given email " + email + " to save band");
	}

	public ResponseEntity<ResponseStructure<MakeUp>> updateMakeUp(int id, MakeUp makeUp) {
		MakeUp makeUpdb = dao.updateMakeUp(makeUp, id);
		ResponseStructure<MakeUp> responseStructure = new ResponseStructure<>();
		if (makeUpdb != null) {

			responseStructure.setMessage("Sucessfully MakeUp is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(makeUp);
			return new ResponseEntity<ResponseStructure<MakeUp>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByMakeUpException("MakeUp is not found for your id " + id + " to update");

		}
	}

	public ResponseEntity<ResponseStructure<MakeUp>> deleteMakeUp(int id) {
		MakeUp makeUpdb = dao.deleteMakeUp(id);
		ResponseStructure<MakeUp> responseStructure = new ResponseStructure<>();
		if (makeUpdb != null) {

			responseStructure.setMessage("Sucessfully MakeUp is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(makeUpdb);
			return new ResponseEntity<ResponseStructure<MakeUp>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByMakeUpException("MakeUp is not found for your id " + id + " to delete");

		}
	}

	public ResponseEntity<ResponseStructure<MakeUp>> getMakeUpById(int id) {
		MakeUp makeUpdb = dao.getMAkeUpById(id);
		ResponseStructure<MakeUp> responseStructure = new ResponseStructure<>();
		if (makeUpdb != null) {

			responseStructure.setMessage("Sucessfully MakeUp  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(makeUpdb);
			return new ResponseEntity<ResponseStructure<MakeUp>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByMakeUpServiceException(
					"MakeUp is not found for your id " + id + " to display");
		}

	}

}
