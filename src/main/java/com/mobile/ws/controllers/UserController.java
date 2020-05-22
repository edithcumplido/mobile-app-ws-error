package com.mobile.ws.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.ws.controllers.exceptions.UserServiceException;
import com.mobile.ws.dto.UserDTO;
import com.mobile.ws.model.request.UserDetailsModelRequest;
import com.mobile.ws.model.response.UserRest;
import com.mobile.ws.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page, 
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "get User : page " + page + " limit:" + limit;
	}
	
	
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId) {
		return "get User : " + userId;
	}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsModelRequest UserDetails) {
		UserRest returnValue = new UserRest();
		
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(UserDetails, userDTO);
		
		UserDTO createdUser = userService.createUser(userDTO);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}

	
	@PutMapping
	public String updateUser() {
		return "updated User";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete User";
	}
	

	
	/*
	 * {
   	"email": "alain@yahoo.com",
	"firstName": "Alain",
	"lastName": "Gonzalez",
	"userId": "123"
}
	 */
}
