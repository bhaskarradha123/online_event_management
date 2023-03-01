package com.ty.online_event_management_web_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.online_event_management_web_app.dao.MenuDao;
import com.ty.online_event_management_web_app.dao.OrganizerDao;
import com.ty.online_event_management_web_app.dto.Menu;
import com.ty.online_event_management_web_app.dto.Organizer;
import com.ty.online_event_management_web_app.exception.IdNotFoundByMenuException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByMenuServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;
	@Autowired
	private OrganizerDao organizerDao;

	public ResponseEntity<ResponseStructure<List<Menu>>> saveMenu(List<Menu> menu, String email) {
		Organizer organizer = organizerDao.getOrganizerByEmail(email);
		if (organizer != null) {
			List<Menu> list = dao.saveMenu(menu, email);
			System.out.println(list);
			ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Menu Is Saved Sucessfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure, HttpStatus.CREATED);
		}
		throw new NoSuchElementFoundByOrganizerException(
				"Organizer is not found for given email " + email + " to save band");
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
		Menu menudb = dao.UpdateMenu(menu, id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menudb != null) {

			responseStructure.setMessage("Sucessfully Menu is Update");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(menudb);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByMenuException("Menu is not found for your id " + id + " to update");

		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) {
		Menu menudb = dao.deleteMenu(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menudb != null) {

			responseStructure.setMessage("Sucessfully Menu is deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(menudb);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundByMenuException("Menu is not found for your id " + id + " to delete");

		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		Menu menudb = dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menudb != null) {
			responseStructure.setMessage("Sucessfully Menu  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(menudb);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByMenuServiceException("Menu is not found for your id " + id + " to display");
		}

	}

	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenuByEmail(String email) {
		List<Menu> menudb = dao.getlistOfMenuByEmail(email);
		ResponseStructure<List<Menu>> responseStructure = new ResponseStructure<>();
		if (menudb != null) {
			responseStructure.setMessage("Sucessfully Menu  is Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(menudb);
			return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchElementFoundByMenuServiceException(
					"Menu is not found for Organizer Email " + email + " to display");
		}

	}

}
