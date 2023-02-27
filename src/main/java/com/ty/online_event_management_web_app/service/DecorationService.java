package com.ty.online_event_management_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.DecorationDao;
import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.exception.IdNotFoundByDecorationException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class DecorationService {
	@Autowired
	private DecorationDao dao;
	@Autowired
	private OrganizerDao organizerDao;

	public ResponseEntity<ResponseStructure<List<Decoration>>> saveDecoration(List<Decoration> decoration ,String email)
	{ 
		Organizer organizer=organizerDao.getOrganizerByEmail(email);
		if(organizer!=null) {
		ResponseStructure<List<Decoration>> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Decoration Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( dao.saveDecoration(decoration, email));
		return new ResponseEntity<ResponseStructure<List<Decoration>>> (responseStructure,HttpStatus.CREATED);
		}
	     throw new NoSuchElementFoundByOrganizerException("Organizer is not found for given email "+email+" to save band");
	}
	public ResponseEntity< ResponseStructure< Decoration>> updateDecoration(int id,  Decoration decoration)
	{
		Decoration decorationdb=dao.UpdateDecoration(decoration, id);
		ResponseStructure<Decoration> responseStructure=new ResponseStructure<>();
		if(decorationdb != null) {
			
			responseStructure.setMessage("Sucessfully Decoration is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(decorationdb);
			return new ResponseEntity< ResponseStructure< Decoration>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByDecorationException("Decoration is not found for your id "+id+" to update");

	}
	}
	
	public ResponseEntity< ResponseStructure< Decoration>> deleteDecoration(int id)
	{
		Decoration decorationdb=dao.deleteDecoration(id);
		ResponseStructure< Decoration> responseStructure=new ResponseStructure<>();
		if(decorationdb != null) {
			
			responseStructure.setMessage("Sucessfully Decoration is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(decorationdb);
			return new ResponseEntity< ResponseStructure<Decoration>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByDecorationException("Decoration is not found for your id "+id+" to delete");

	}
	}
	
	public ResponseEntity< ResponseStructure< Decoration>> getDecorationById(int id)
	{
		Decoration decorationdb=dao.getDecorationById(id);
		ResponseStructure< Decoration> responseStructure=new ResponseStructure<>();
		if(decorationdb != null) {
			
			responseStructure.setMessage("Sucessfully Menu  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(decorationdb);
			return new ResponseEntity< ResponseStructure< Decoration>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByDecorationException("Decoration is not found for your id "+id+" to display");
	}
		 
	}
	
	
	
}
