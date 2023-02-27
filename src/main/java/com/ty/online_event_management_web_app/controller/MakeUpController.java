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

import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.service.MakeUpService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MakeUpController {
 
	@Autowired
	private MakeUpService service;
	
	
	@PostMapping("/makeup")
	@ApiOperation(value = "save MakeUp", notes = "Api is used to save MakeUp ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<MakeUp>> saveMakeUp(@Valid@RequestBody MakeUp makeUp,@RequestParam String email) {
		return service.saveMakeUp(makeUp, email);
	}
           
	@PutMapping("makeup")
	@ApiOperation(value = "update MakeUp", notes = "Api is used to update MakeUp with given MakeUp id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given MakeUp Id")})
	public ResponseEntity<ResponseStructure<MakeUp>> updateMakeUp(@RequestParam int id,@Valid@RequestBody MakeUp makeUp) {
		return service.updateMakeUp(id, makeUp);
	}

	@DeleteMapping("/makeup")
	@ApiOperation(value = "delete MakeUp", notes = "Api is used to delete MakeUp with given MakeUp id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="id is  not Found for the given MakeUp id")})
	public ResponseEntity<ResponseStructure<MakeUp>> deleteMakeUp(@RequestParam int id) {
		return service.deleteMakeUp(id);
	}

	@GetMapping("/makeup")
	@ApiOperation(value = "display MakeUp", notes = "Api is used to display MakeUp with given MakeUp id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" id  is not Found for the given MakeUp id")})
	public ResponseEntity<ResponseStructure<MakeUp>> getMakeUpById(@RequestParam int id) {
		return service.getMakeUpById(id);
	}	
	
	
	

}
