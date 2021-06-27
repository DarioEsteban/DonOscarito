package com.usm.donoscarito.controllersImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ums.donoscarito.controllers.UserTypeController;
import com.usm.donoscarito.entities.UserType;
import com.usm.donoscarito.service.UserTypeService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@ApiResponses({ 
	@ApiResponse(code = 200, message = "Ok"),
	@ApiResponse(code = 409, message = "Conflict"),
	@ApiResponse(code = 500, message = "Internal Server Error")
	})
//@RequestMapping(value = "/userType")
public class UserTypeControllerImpl implements UserTypeController  {

	@Autowired
	UserTypeService userTypeService; 
		
	@RequestMapping(value = "/usertype", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<UserType> getUsersTypes() {
		// TODO Auto-generated method stub
		return userTypeService.findAllUsersTypes();
	}
	
}
