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
import com.ty.online_event_management_web_app.dto.UserOccassion;
import com.ty.online_event_management_web_app.service.UserOcassionService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserOccassionController {

	@Autowired
	private UserOcassionService service;

	@PostMapping("/userOccassion")
	@ApiOperation(value = "save UserOccassion", notes = "Api is used to save UserOcassion ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully Created ") })
	public ResponseEntity<ResponseStructure<UserOccassion>> saveUserOccassion(
			@Valid @RequestBody UserOccassion occassion, @RequestParam String email) {
		return service.saveUserOccassion(occassion, email);
	}

	@PutMapping("/userOccassion")
	@ApiOperation(value = "update userOccassion", notes = "Api is used to update userOccassion with given userOccassion Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully updated "),
			@ApiResponse(code = 404, message = "Id is  not Found for the given userOccassion Id") })
	public ResponseEntity<ResponseStructure<UserOccassion>> updateCostume(@RequestParam int id,
			@Valid @RequestBody UserOccassion occassion) {
		return service.updateUserOcassion(id, occassion);
	}

	@DeleteMapping("/userOccassion")
	@ApiOperation(value = "delete userOccassion", notes = "Api is used to delete  userOccassion with given userOccassion Id")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully deleted "),
			@ApiResponse(code = 404, message = "Id is  not Found for the given userOccassion Id") })
	public ResponseEntity<ResponseStructure<UserOccassion>> deleteCostume(@RequestParam int id) {
		return service.deleteUserOccassion(id);
	}

	@GetMapping("/userOccassion")
	@ApiOperation(value = "display userOccassion", notes = "Api is used to display userOccassion with given userOccassion ID")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully found to display "),
			@ApiResponse(code = 404, message = " Id is not Found for the given userOccassion Id") })
	public ResponseEntity<ResponseStructure<UserOccassion>> getCostumeById(@RequestParam int id) {
		return service.getUserOccassionById(id);
	}

	@GetMapping("/userOccassions")
	@ApiOperation(value = "display userOccassions", notes = "Api is used to display userOccassions with given userOccassion ID")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully found to display "),
			@ApiResponse(code = 404, message = " Id is not Found for the given userOccassion Id") })
	public ResponseEntity<ResponseStructure<List<UserOccassion>>> getCostumeById(@RequestParam String email) {
		return service.getListOfUsers(email);
	}

}
