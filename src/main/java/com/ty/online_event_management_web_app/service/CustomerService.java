package com.ty.online_event_management_web_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.CustomerDao;
import com.ty.online_event_management_web_app.dto.User;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByUserException;
import com.ty.online_event_management_web_app.util.ResponseStructure;



@Service
public class CustomerService {


	@Autowired
	private CustomerDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveCustomer(User user)
	{
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("User Is Saved Sucessfully");
		responseStructure.setStatus( HttpStatus.CREATED.value());
		responseStructure.setData( dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>> (responseStructure,HttpStatus.CREATED);	
	}
	public ResponseEntity< ResponseStructure< User>> updateUser(String email,  User user)
	{
		User userdb=dao.UpdateUser(user, email);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if(userdb != null) {
			
			responseStructure.setMessage("Sucessfully User is Update");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(user);
			return new ResponseEntity< ResponseStructure< User>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new NoSuchElementFoundByUserException("user is not found for your email "+email+" to update");
	}
	}
	
	public ResponseEntity< ResponseStructure< User>> deleteUser(String email)
	{
		User userdb=dao.deleteUser(email);
		ResponseStructure< User> responseStructure=new ResponseStructure<>();
		if(userdb != null) {
			
			responseStructure.setMessage("Sucessfully User is deleted");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(userdb);
			return new ResponseEntity< ResponseStructure<User>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new NoSuchElementFoundByUserException("user is not found for your email "+email+" to delete");
	}
	}
	
	public ResponseEntity< ResponseStructure< User>> getByEmail(String email)
	{
		User userdb=dao.getUserByEmail(email);
		ResponseStructure< User> responseStructure=new ResponseStructure<>();
		if(userdb != null) {
			
			responseStructure.setMessage("Sucessfully User  is Found");
			responseStructure.setStatus( HttpStatus.OK.value());
			responseStructure.setData(userdb);
			return new ResponseEntity< ResponseStructure< User>> (responseStructure, HttpStatus.OK);
		}else {
		     throw new NoSuchElementFoundByUserException("user is not found for your email "+email+" to display");
	}
		 
	}	
}
