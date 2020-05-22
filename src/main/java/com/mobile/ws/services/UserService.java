package com.mobile.ws.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mobile.ws.dto.UserDTO;

public interface UserService extends UserDetailsService{

	UserDTO createUser(UserDTO userdto);
	
}
