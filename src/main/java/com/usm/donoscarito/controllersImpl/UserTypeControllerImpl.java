package com.usm.donoscarito.controllersImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ums.donoscarito.controllers.UserTypeController;
import com.usm.donoscarito.entities.UserType;
import com.usm.donoscarito.service.UserTypeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@ApiResponses({ 
	@ApiResponse(code = 200, message = "Ok"),
	@ApiResponse(code = 409, message = "Conflict"),
	@ApiResponse(code = 500, message = "Internal Server Error")
	})
@RequestMapping(value = "/userType")
public class UserTypeControllerImpl implements UserTypeController  {

	@Autowired
	UserTypeService userTypeService; 
		
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<UserType> getUsersTypes() {
		// TODO Auto-generated method stub
		return userTypeService.findAllUsersTypes();
	}
	
	@ApiOperation(value = "Agregar un rol de usuario.")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces={"application/json"})	
	@Override
	public ResponseEntity<String> addUserType(@RequestBody UserType userType) {
		try {
			userTypeService.save(userType); 
			return new ResponseEntity<String>("",HttpStatus.OK);
		}
		catch(IllegalArgumentException iex)
		{
			return new ResponseEntity<String>("{\"message\":\""+iex.getMessage()+"\"}",HttpStatus.CONFLICT);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("{\"message\":\""+ex.getMessage()+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Modificar una rol de usuario.")
	@RequestMapping(value = "/update", method = RequestMethod.PATCH, produces={"application/json"})	
	@Override
	public ResponseEntity<String> updateUserType(@RequestBody UserType userType) {
		try {
			userTypeService.update(userType); 
			return new ResponseEntity<String>("",HttpStatus.OK);
		}
		catch(IllegalArgumentException iex)
		{
			return new ResponseEntity<String>("{\"message\":\""+iex.getMessage()+"\"}",HttpStatus.CONFLICT);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("{\"message\":\""+ex.getMessage()+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
