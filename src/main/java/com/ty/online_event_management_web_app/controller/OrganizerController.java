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

import com.ty.online_event_management_web_app.dto.Band;
import com.ty.online_event_management_web_app.dto.Costume;
import com.ty.online_event_management_web_app.dto.Decoration;
import com.ty.online_event_management_web_app.dto.MakeUp;
import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.dto.Photographer;
import com.ty.online_event_management_web_app.dto.Purohith;
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
	public ResponseEntity<ResponseStructure<Organizer>> saveOrganizer(@Valid@RequestBody Organizer organizer) {
		return service.saveOrganizer(organizer);
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
	
	@GetMapping("/bandservice")
	@ApiOperation(value = "display bandservice list", notes = "Api is used to display bandservice list with given bandservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" bandservice list  is not Found for the given bandservice ")})
	public ResponseEntity<ResponseStructure<List<Band>>> getListOfBand(@RequestParam String bandservice){
		return service.getListOfBand(bandservice);
	}
	
	@GetMapping("/costumeservice")
	@ApiOperation(value = "display costumeservice list", notes = "Api is used to display costumeservice list with given costumeservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" costumeservice list  is not Found for the given costumeservice ")})
	public ResponseEntity<ResponseStructure<List<Costume>>> getListOfCostume(@RequestParam String costumeservice){
		return service.getListOfCostume(costumeservice);
	}
	@GetMapping("/decorationservice")
	@ApiOperation(value = "display decorationservice list", notes = "Api is used to display decorationservice list with given decorationservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" decorationservice list  is not Found for the given decorationservice ")})
	public ResponseEntity<ResponseStructure<List<Decoration>>> getListOfDecoration(@RequestParam String decorationservice){
		return service.getListOfDecoration(decorationservice);
	}
	@GetMapping("/makeupservice")
	@ApiOperation(value = "display makeupservice list", notes = "Api is used to display makeupservice list with given makeupservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" makeupservice list  is not Found for the given makeupservice ")})
	public ResponseEntity<ResponseStructure<List<MakeUp>>> getListOfMakeUp(@RequestParam String makeupservice){
		return service.getListOfMakeUp(makeupservice);
	}
	@GetMapping("/menuservice")
	@ApiOperation(value = "display menuservice list", notes = "Api is used to display menuservice list with given menuservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" menuservice list  is not Found for the given menuservice ")})
	public ResponseEntity<ResponseStructure<List<Menu>>> getListOfMenu(@RequestParam String menuservice){
		return service.getListOfMenu(menuservice);
	}
	@GetMapping("/photoservice")
	@ApiOperation(value = "display photoservice list", notes = "Api is used to display photoservice list with given photoservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" bandservice list  is not Found for the given photoservice ")})
	public ResponseEntity<ResponseStructure<List<Photographer>>> getListOfPhotographer(@RequestParam String photoservice){
		return service.getListOfPhotographer(photoservice);
	}
	@GetMapping("/purohithservice")
	@ApiOperation(value = "display purohithservice list", notes = "Api is used to display purohithservice list with given purohithservice")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully found to display "),
		@ApiResponse(code=404,message=" bandservice list  is not Found for the given purohithservice ")})
	public ResponseEntity<ResponseStructure<List<Purohith>>> getListOfPurohith(@RequestParam String purohithservice){
		return service.getListOfPurohith(purohithservice);
	}
	
	
	
	
	
	

}
