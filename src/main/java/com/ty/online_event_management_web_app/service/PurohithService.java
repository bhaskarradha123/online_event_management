package com.ty.online_event_management_web_app.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dao.ProhitDao;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Purohith;
import com.ty.online_event_management_web_app.exception.IdNotFoundByPurohithException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByBandServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByPurohithServiceException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class PurohithService {
	@Autowired
	private ProhitDao dao;
	@Autowired
	private OrganizerDao organizerdao;

	public ResponseEntity<ResponseStructure<Purohith>> savePurohith(Purohith purohith, String email) {
		Organizer organizer = organizerdao.getOrganizerByEmail(email);
		if (organizer != null) {
			ResponseStructure<Purohith> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Purohith Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveProhith(purohith, email));
			return new ResponseEntity<ResponseStructure<Purohith>>(responseStructure, HttpStatus.CREATED);
		} else
			throw new NoSuchElementFoundByOrganizerException(
					"Organizer is not found for given email " + email + " to save purohith");

	}

	public ResponseEntity<ResponseStructure<Purohith>> updatePurohith(String id, Purohith purohith) {
		Purohith purohithdb = dao.updatePurohith(purohith, id);
		ResponseStructure<Purohith> responseStructure = new ResponseStructure<>();
		if (purohithdb != null) {

			responseStructure.setMessage("Sucessfully Purohith is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(purohith);
			return new ResponseEntity<ResponseStructure<Purohith>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByPurohithException("Purohith is not found for your id " + id + " to update");

		}
	}

	public ResponseEntity<ResponseStructure<Purohith>> deletePurohith(String id) {
		Purohith purohithdb = dao.deletePurohith(id);
		ResponseStructure<Purohith> responseStructure = new ResponseStructure<>();
		if (purohithdb != null) {

			responseStructure.setMessage("Sucessfully Purohith is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(purohithdb);
			return new ResponseEntity<ResponseStructure<Purohith>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByPurohithException("Purohith is not found for your id " + id + " to delete");

		}
	}

	public ResponseEntity<ResponseStructure<Purohith>> getPurohithById(String id) {
		Purohith purohithdb = dao.getPurohithById(id);
		ResponseStructure<Purohith> responseStructure = new ResponseStructure<>();
		if (purohithdb != null) {

			responseStructure.setMessage("Sucessfully Purohith  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(purohithdb);
			return new ResponseEntity<ResponseStructure<Purohith>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByPurohithServiceException(
					"Purohith is not found for your id " + id + " to display");
		}

	}
	
	public ResponseEntity<ResponseStructure<Double>> getPurohithBillById(String id) {
		Purohith purohithdb = dao.getPurohithById(id);
		ResponseStructure<Double> responseStructure = new ResponseStructure<>();
		if (purohithdb != null) {

			responseStructure.setMessage("Sucessfully PurohithBill  is Generated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(purohithdb.getFees());
			return new ResponseEntity<ResponseStructure<Double>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByBandServiceException("Purohith is not found for your id " + id + " to generate bill");
		}

	}
	
	

}
