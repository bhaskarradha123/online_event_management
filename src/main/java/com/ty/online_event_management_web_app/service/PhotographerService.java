package com.ty.online_event_management_web_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.BandDao;
import com.ty.online_event_management_web_app.dao.DecorationDao;
import com.ty.online_event_management_web_app.dao.MakeUpDao;
import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dao.PhotographerDao;
import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.exception.IdNotFoundByBandException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByMakeUpException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByPhotographerException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class PhotographerService {
    @Autowired
	private PhotographerDao dao;
    
    @Autowired
    private OrganizerDao organizerdao;
    
	public ResponseEntity<ResponseStructure<Photographer>> savePhotographer(Photographer photographer ,String email)
	{ 
		Organizer organizer=organizerdao.getOrganizerByEmail(email);
		if(organizer!=null) {
		ResponseStructure<Photographer> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Photographer Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( dao.savePhotographer(photographer, email));
		return new ResponseEntity<ResponseStructure<Photographer>> (responseStructure,HttpStatus.CREATED);
		}
	     throw new NoSuchElementFoundByOrganizerException("Organizer is not found for given email "+email+" to save band");
	}
	public ResponseEntity< ResponseStructure< Photographer>> updatePhotographer(int id,  Photographer photographer)
	{
		Photographer photographerdb=dao.updatePhotographer(photographer, id);
		ResponseStructure<Photographer> responseStructure=new ResponseStructure<>();
		if(photographerdb != null) {
			
			responseStructure.setMessage("Sucessfully Photographer is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(photographer);
			return new ResponseEntity< ResponseStructure< Photographer>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByPhotographerException("Photographer is not found for your id "+id+" to update");

	}
	}
	
	public ResponseEntity< ResponseStructure< Photographer>> deletePhotographer(int id)
	{
		Photographer photographerdb=dao.deleteVenue(id);
		ResponseStructure< Photographer> responseStructure=new ResponseStructure<>();
		if(photographerdb != null) {
			
			responseStructure.setMessage("Sucessfully Photographer is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(photographerdb);
			return new ResponseEntity< ResponseStructure<Photographer>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByPhotographerException("Photographer is not found for your id "+id+" to delete");

	}
	}
	
	public ResponseEntity< ResponseStructure< Photographer>> getPhotographerById(int id)
	{
		Photographer photographerdb=dao.getPhotographerById(id);
		ResponseStructure< Photographer> responseStructure=new ResponseStructure<>();
		if(photographerdb != null) {
			
			responseStructure.setMessage("Sucessfully Photographer  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(photographerdb);
			return new ResponseEntity< ResponseStructure< Photographer>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByPhotographerException("Photographer is not found for your id "+id+" to display");
	}
		 
	}
	
	
	
	
}
