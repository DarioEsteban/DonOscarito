package com.usm.donoscarito.service;

import java.util.List;

import com.usm.donoscarito.entities.UserType;

public interface UserTypeService {
	
	public List<UserType> findAllUsersTypes();

	public void save(UserType userType);

	public void update(UserType userType);

}
