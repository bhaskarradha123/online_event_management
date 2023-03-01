package com.ty.online_event_management_web_app.controller;

import java.util.List;


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


import com.ty.online_event_management_web_app.dto.Organizer;

import com.ty.online_event_management_web_app.service.OrganizerService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrganizerController {

	@Autowired
	private OrganizerService service;
	
	@PostMapping("/organizer")
	@ApiOperation(value = "save organizer", notes = "Api is used to save organizer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created ")})
	public ResponseEntity<ResponseStructure<Organizer>> saveOrganizer(@Valid@RequestBody Organizer organizer,@RequestParam String email) {
		return service.saveOrganizer(organizer,email);
	}

	@PutMapping("organizer")
	@ApiOperation(value = "update organizer", notes = "Api is used to update organizer with given organizer email")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="email is not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(@RequestParam String email,@Valid@RequestBody Organizer organizer) {
		return service.updateOrganizer(email, organizer);
	}

	@DeleteMapping("/organizer")
	@ApiOperation(value = "delete organizer", notes = "Api is used to delete organizer with given organizer email")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Organizer>> deleteOrganizer(@RequestParam String email) {
		return service.deleteOrganizer(email);
	}

	@GetMapping("/organizer")
	@ApiOperation(value = "display organizer", notes = "Api is used to display organizer with given organizer email")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" email  is not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(@RequestParam String email) {
		return service.getByEmail(email);
	}
	
	
	
	
	
	@GetMapping("/organizerservice")
	@ApiOperation(value = "display purohithservice list", notes = "Api is used to display purohithservice list with given purohithservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" bandservice list  is not Found for the given purohithservice ")})
	public ResponseEntity<ResponseStructure<List<Organizer>>> getListOfService(@RequestParam String organizerservice){
		return service.getListOfService(organizerservice);
	}
	
	
	@GetMapping("/organizerlogin")
	@ApiOperation(value = "login organizer", notes = "Api is used to login organizer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message=" email  is not Found for the given user email")})
	public ResponseEntity<ResponseStructure<Organizer>> loginOrganizer(@Valid@RequestParam String email ,@RequestParam String pwd) {
		return service.loginOrganizer(email, pwd);
	}
	
	
	

}
