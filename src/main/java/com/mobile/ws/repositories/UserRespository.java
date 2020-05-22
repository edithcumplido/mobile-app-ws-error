package com.mobile.ws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.ws.entities.UserEntity;

@Repository
public interface UserRespository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	
}
