package com.ty.online_event_management_web_app.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.online_event_management_web_app.dto.Venue;
import com.ty.online_event_management_web_app.service.VenueService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class VenueController {
	
	

	@Autowired
	private VenueService service;
	
	@PostMapping("/venue")
	@ApiOperation(value = "save venue", notes = "Api is used to save venue ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Venue>> saveVenue(@Valid@RequestBody Venue venue,@RequestParam String email) {
		return service.saveVenue(venue, email);
	}
           
	@PutMapping("venue")
	@ApiOperation(value = "update Venue", notes = "Api is used to update Venue with given Venue id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given Venue Id")})
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestParam int id,@Valid@RequestBody Venue venue) {
		return service.updateVenue(id, venue);
	}

	@DeleteMapping("/venue")
	@ApiOperation(value = "delete Venue", notes = "Api is used to delete Venue with given Venue id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="id is  not Found for the given Venue id")})
	public ResponseEntity<ResponseStructure<Venue>> deleteVenue(@RequestParam int id) {
		return service.deleteVenue(id);
	}

	@GetMapping("/venue")
	@ApiOperation(value = "display Venue", notes = "Api is used to display Venue with given Venue id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" id  is not Found for the given Venue id")})
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@RequestParam int id) {
		return service.getVenueById(id);
	}

}
