package com.usm.donoscarito.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.UserType;
import com.usm.donoscarito.repository.UserTypeRepository;
import com.usm.donoscarito.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public List<UserType> findAllUsersTypes() {
		// TODO Auto-generated method stub
		return userTypeRepository.findAll();
	}
	
	
}
