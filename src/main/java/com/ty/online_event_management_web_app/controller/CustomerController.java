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

import com.ty.online_event_management_web_app.dto.User;
import com.ty.online_event_management_web_app.service.CustomerService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {
	
	

	@Autowired
	private CustomerService service;
	
	@PostMapping("/user")
	@ApiOperation(value = "save user", notes = "Api is used to save user ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created ")})
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid@RequestBody User user) {
		return service.saveCustomer(user);
	}
           
	@PutMapping("user")
	@ApiOperation(value = "update user", notes = "Api is used to update user with given user email")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="email is  not Found for the given user email")})
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam String email,@Valid@RequestBody User user) {
		return service.updateUser(email, user);
	}

	@DeleteMapping("/user")
	@ApiOperation(value = "delete user", notes = "Api is used to delete user with given user email")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="email is  not Found for the given user email")})
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam String email) {
		return service.deleteUser(email);
	}

	@GetMapping("/user")
	@ApiOperation(value = "display user", notes = "Api is used to display user with given person email")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" email  is not Found for the given user email")})
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam String email) {
		return service.getByEmail(email);
	}

}
