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

import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.service.PhotographerService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PhotographerController {
	
	

	@Autowired
	private PhotographerService service;
	
	@PostMapping("/photographer")
	@ApiOperation(value = "save photographer", notes = "Api is used to save photographer ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Photographer>> savePhotographer(@Valid@RequestBody Photographer photographer,@RequestParam String email) {
		return service.savePhotographer(photographer, email);
	}
           
	@PutMapping("photographer")
	@ApiOperation(value = "update photographer", notes = "Api is used to update photographer with given photographer id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given photographer Id")})
	public ResponseEntity<ResponseStructure<Photographer>> updatePhotographer(@RequestParam int id,@Valid@RequestBody Photographer photographer) {
		return service.updatePhotographer(id, photographer);
	}

	@DeleteMapping("/photographer")
	@ApiOperation(value = "delete photographer", notes = "Api is used to delete photographer with given photographer id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="id is  not Found for the given photographer id")})
	public ResponseEntity<ResponseStructure<Photographer>> deletePhotographer(@RequestParam int id) {
		return service.deletePhotographer(id);
	}

	@GetMapping("/photographer")
	@ApiOperation(value = "display photographer", notes = "Api is used to display photographer with given photographer id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" id  is not Found for the given photographer id")})
	public ResponseEntity<ResponseStructure<Photographer>> getPhotographerById(@RequestParam int id) {
		return service.getPhotographerById(id);
	}

}
