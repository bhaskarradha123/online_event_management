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

import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.service.MenuService;
import com.ty.online_event_management_web_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@PostMapping("/menu")
	@ApiOperation(value = "save Menu", notes = "Api is used to save Menu ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully Created "),
		@ApiResponse(code=404,message="email is  not Found for the given organizer email")})
	public ResponseEntity<ResponseStructure<List<Menu>>> saveMenu(@Valid@RequestBody List<Menu>menu,@RequestParam String email) {
		return service.saveMenu(menu, email);
	}
           
	@PutMapping("menu")
	@ApiOperation(value = "update Menu", notes = "Api is used to update Menu with given Menu id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully updated "),
		@ApiResponse(code=404,message="Id not Found for the given Menu Id")})
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id,@Valid@RequestBody Menu menu) {
		return service.updateMenu(id, menu);
	}

	@DeleteMapping("/menu")
	@ApiOperation(value = "delete Menu", notes = "Api is used to delete Menu with given Menu id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully deleted "),
		@ApiResponse(code=404,message="id is  not Found for the given Menu id")})
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int id) {
		return service.deleteMenu(id);
	}

	@GetMapping("/menu")
	@ApiOperation(value = "display Menu", notes = "Api is used to display Menu with given Menu id")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" id  is not Found for the given Menu id")})
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int id) {
		return service.getMenuById(id);
	}

}
