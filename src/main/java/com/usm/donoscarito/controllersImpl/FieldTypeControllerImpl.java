package com.usm.donoscarito.controllersImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ums.donoscarito.controllers.FieldTypeController;
import com.usm.donoscarito.entities.FieldType;
import com.usm.donoscarito.service.FieldTypeService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@ApiResponses({ 
	@ApiResponse(code = 200, message = "Ok"),
	@ApiResponse(code = 409, message = "Conflict"),
	@ApiResponse(code = 500, message = "Internal Server Error")
	})
@RequestMapping(value = "/fieldType")
public class FieldTypeControllerImpl implements FieldTypeController  {

	@Autowired
	FieldTypeService fieldTypeService; 
		
	@RequestMapping(value = "/fieldtype", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<FieldType> getFieldsTypes() {
		// TODO Auto-generated method stub
		return fieldTypeService.findAllFieldsTypes();
	}
	
}
