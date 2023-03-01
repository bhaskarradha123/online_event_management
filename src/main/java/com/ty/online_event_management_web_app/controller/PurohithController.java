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

import com.ty.online_event_management_web_app.dto.Purohith;
import com.ty.online_event_management_web_app.service.PurohithService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PurohithController {
	
	

	@Autowired
	private PurohithService service;
	
	@PostMapping("/purohith")
	@ApiOperation(value = "save purohith", notes = "Api is used to save purohith ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<Purohith>> savePurohith(@Valid@RequestBody Purohith purohith,@RequestParam String email) {
		return service.savePurohith(purohith, email);
	}
           
//	@PutMapping("purohith")
//	@ApiOperation(value = "update purohith", notes = "Api is used to update purohith with given purohith id")
//	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
//		@ApiResponse(code=404,message="Id not Found for the given purohith Id")})
//	public ResponseEntity<ResponseStructure<Purohith>> updatePurohith(@RequestParam int id,@Valid@RequestBody Purohith purohith) {
//		return service.updatePurohith(id, purohith);
//	}
//
//	@DeleteMapping("/purohith")
//	@ApiOperation(value = "delete purohith", notes = "Api is used to delete purohith with given purohith id")
//	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
//		@ApiResponse(code=404,message="id is  not Found for the given purohith id")})
//	public ResponseEntity<ResponseStructure<Purohith>> deletePurohith(@RequestParam int id) {
//		return service.deletePurohith(id);
//	}
//
//	@GetMapping("/purohith")
//	@ApiOperation(value = "display purohith", notes = "Api is used to display purohith with given purohith id")
//	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
//		@ApiResponse(code=404,message=" id  is not Found for the given purohith id")})
//	public ResponseEntity<ResponseStructure<Purohith>> getPurohithById(@RequestParam int id) {
//		return service.getPurohithById(id);
//	}

}
