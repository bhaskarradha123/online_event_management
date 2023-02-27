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

import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.service.DecorationService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DecorationController {
	@Autowired
	private DecorationService service;
	
	@PostMapping("/decoration")
	@ApiOperation(value = "save Decoration", notes = "Api is used to save Decoration ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<List<Decoration>>> saveDecoration(@Valid@RequestBody List<Decoration>decoration,@RequestParam String email) {
		return service.saveDecoration(decoration, email);
	}
           
	@PutMapping("decoration")
	@ApiOperation(value = "update Decoration", notes = "Api is used to update Decoration with given Decoration id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given Decoration Id")})
	public ResponseEntity<ResponseStructure<Decoration>> updateDecoration(@RequestParam int id,@Valid@RequestBody Decoration decoration) {
		return service.updateDecoration(id, decoration);
	}

	@DeleteMapping("/decoration")
	@ApiOperation(value = "delete Decoration", notes = "Api is used to delete Decoration with given Decoration id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="id is  not Found for the given Decoration id")})
	public ResponseEntity<ResponseStructure<Decoration>> deleteDecoration(@RequestParam int id) {
		return service.deleteDecoration(id);
	}

	@GetMapping("/decoration")
	@ApiOperation(value = "display Decoration", notes = "Api is used to display Decoration with given Decoration id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" id  is not Found for the given Decoration id")})
	public ResponseEntity<ResponseStructure<Decoration>> getDecorationById(@RequestParam int id) {
		return service.getDecorationById(id);
	}

	
	

}
