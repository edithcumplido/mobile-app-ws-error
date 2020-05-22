package com.mobile.ws.services.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mobile.ws.dto.UserDTO;
import com.mobile.ws.entities.UserEntity;
import com.mobile.ws.help.Utils;
import com.mobile.ws.repositories.UserRespository;
import com.mobile.ws.services.UserService;

@Service
public class UserServicesImpl implements UserService {

	@Autowired
	UserRespository userRespository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		
		if (userRespository.findByEmail(userdto.getEmail()) != null) throw new RuntimeException("Record already exist");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userdto, userEntity);
		
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userdto.getPassword()));	
		//userEntity.setEncryptedPassword("test");	
		userEntity.setUserId(utils.generateUserId(30));
		
		UserEntity userStored = userRespository.save(userEntity);
		
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(userStored, returnValue);
		
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
