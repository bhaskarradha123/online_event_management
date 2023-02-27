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

import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.service.BandService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BandController {
	
	

	@Autowired
	private BandService service;
	
	@PostMapping("/band")
	@ApiOperation(value = "save band", notes = "Api is used to save band ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Band>> saveBand(@Valid@RequestBody Band band,@RequestParam String email) {
		return service.saveBand(band, email);
	}
           
	@PutMapping("band")
	@ApiOperation(value = "update band", notes = "Api is used to update band with given band id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given band Id")})
	public ResponseEntity<ResponseStructure<Band>> updateBand(@RequestParam int id,@Valid@RequestBody Band band) {
		return service.updateBand(id, band);
	}

	@DeleteMapping("/band")
	@ApiOperation(value = "delete band", notes = "Api is used to delete band with given band id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="id is  not Found for the given band id")})
	public ResponseEntity<ResponseStructure<Band>> deleteBand(@RequestParam int id) {
		return service.deleteBand(id);
	}

	@GetMapping("/band")
	@ApiOperation(value = "display Band", notes = "Api is used to display Band with given Band id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" id  is not Found for the given band id")})
	public ResponseEntity<ResponseStructure<Band>> getBandById(@RequestParam int id) {
		return service.getBandById(id);
	}

}
