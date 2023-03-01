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

import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.service.CostumeService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CostumeController {

	@Autowired
	private CostumeService service;

	@PostMapping("/costume")
	@ApiOperation(value = "save Costume", notes = "Api is used to save List of Costume ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Created ") })
	public ResponseEntity<ResponseStructure<List<Costume>>> saveUser(@Valid @RequestBody List<Costume> costume,
			@RequestParam String email) {
		return service.saveCostume(costume, email);
	}

	@PutMapping("/costume")
	@ApiOperation(value = "update Costume", notes = "Api is used to update Costume with given Costume Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully updated "),
			@ApiResponse(code = 404, message = "Id is  not Found for the given Costume Id") })
	public ResponseEntity<ResponseStructure<Costume>> updateCostume(@RequestParam int id,
			@Valid @RequestBody Costume costume) {
		return service.updateCostume(costume, id);
	}

	@DeleteMapping("/costume")
	@ApiOperation(value = "delete Costume", notes = "Api is used to delete  Costume with given Costume Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully deleted "),
			@ApiResponse(code = 404, message = "Id is  not Found for the given Costume Id") })
	public ResponseEntity<ResponseStructure<Costume>> deleteCostume(@RequestParam int id) {
		return service.deleteCostume(id);
	}

	@GetMapping("/costume")
	@ApiOperation(value = "display costume", notes = "Api is used to display Costume with given Costume ID")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully found to display "),
			@ApiResponse(code = 404, message = " Id is not Found for the given Costume Id") })
	public ResponseEntity<ResponseStructure<Costume>> getCostumeById(@RequestParam int id) {
		return service.getCostumeById(id);
	}

 
	@GetMapping("/costumes")
	@ApiOperation(value = "display Costumess", notes = "Api is used to display Costumes with given Organizer email ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully found to display "),
			@ApiResponse(code = 404, message = " id  is not Found for the given Costume email") })
	public ResponseEntity<ResponseStructure<List<Costume>>> getMenuById(@RequestParam String email) {
		return service.getAllCostumeByEmail(email);
	}

}
