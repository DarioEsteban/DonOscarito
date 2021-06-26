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

import com.ums.donoscarito.controllers.UserController;
import com.usm.donoscarito.entities.User;
import com.usm.donoscarito.service.UserService;

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
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	
	@ApiOperation(value = "Agregar una usuario.")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces={"application/json"})	
	@Override
	public ResponseEntity<String> addUser(@RequestBody User user) {
		try {
			userService.save(user); 
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

	@ApiOperation(value = "Modificar una usuario.")
	@RequestMapping(value = "/update", method = RequestMethod.PATCH, produces={"application/json"})	
	@Override
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		try {
			userService.update(user); 
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

	@ApiOperation(value = "Obtener usuario.")
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<User> getUsers() {

		return userService.getUsers();
	}

}
