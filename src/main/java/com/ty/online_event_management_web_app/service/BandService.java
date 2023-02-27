package com.ty.online_event_management_web_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.BandDao;
import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.exception.IdNotFoundByBandException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class BandService {
    @Autowired
	private BandDao dao;
    
    @Autowired
    private OrganizerDao organizerdao;
    
	public ResponseEntity<ResponseStructure<Band>> saveBand(Band band ,String email)
	{ 
		Organizer organizer=organizerdao.getOrganizerByEmail(email);
		if(organizer!=null) {
		ResponseStructure<Band> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("User Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( dao.saveBand(band, email));
		return new ResponseEntity<ResponseStructure<Band>> (responseStructure,HttpStatus.CREATED);
		}
	     throw new NoSuchElementFoundByOrganizerException("Organizer is not found for given email "+email+" to save band");
	}
	public ResponseEntity< ResponseStructure< Band>> updateBand(int id,  Band band)
	{
		Band banddb=dao.updateBand(band,id);
		ResponseStructure<Band> responseStructure=new ResponseStructure<>();
		if(banddb != null) {
			
			responseStructure.setMessage("Sucessfully Band is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(band);
			return new ResponseEntity< ResponseStructure< Band>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByBandException("band is not found for your id "+id+" to update");

	}
	}
	
	public ResponseEntity< ResponseStructure< Band>> deleteBand(int id)
	{
		Band banddb=dao.deleteBand(id);
		ResponseStructure< Band> responseStructure=new ResponseStructure<>();
		if(banddb != null) {
			
			responseStructure.setMessage("Sucessfully Band is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(banddb);
			return new ResponseEntity< ResponseStructure<Band>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByBandException("band is not found for your id "+id+" to delete");

	}
	}
	
	public ResponseEntity< ResponseStructure< Band>> getBandById(int id)
	{
		Band banddb=dao.getBandById(id);
		ResponseStructure< Band> responseStructure=new ResponseStructure<>();
		if(banddb != null) {
			
			responseStructure.setMessage("Sucessfully Band  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(banddb);
			return new ResponseEntity< ResponseStructure< Band>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new IdNotFoundByBandException("band is not found for your id "+id+" to display");
	}
		 
	}
	
	
	
	
}
