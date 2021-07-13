package com.ums.donoscarito.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.usm.donoscarito.entities.UserType;

public interface UserTypeController {

	public List<UserType> getUsersTypes();

	public ResponseEntity<String> addUserType(UserType userType);

	public ResponseEntity<String> updateUserType(UserType userType);	
	
}
