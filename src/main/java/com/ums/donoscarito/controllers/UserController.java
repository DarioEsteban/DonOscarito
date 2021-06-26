package com.ums.donoscarito.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.usm.donoscarito.entities.User; 

public interface UserController {

	public ResponseEntity<String> addUser(User user);
	
	public ResponseEntity<String> updateUser(User user);
	
	public List<User> getUsers();
	
}
