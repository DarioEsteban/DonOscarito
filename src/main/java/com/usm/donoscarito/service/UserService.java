package com.usm.donoscarito.service;
 
import java.util.List;

import com.usm.donoscarito.entities.User; 

public interface UserService {
	
	public void save(User user); 
	
	public void update(User user);
	
	public List<User> getUsers();
	
}
