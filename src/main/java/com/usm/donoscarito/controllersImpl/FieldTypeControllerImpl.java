package com.usm.donoscarito.controllersImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ums.donoscarito.controllers.FieldTypeController;
import com.usm.donoscarito.entities.FieldType;
import com.usm.donoscarito.service.FieldTypeService;

@RestController
public class FieldTypeControllerImpl implements FieldTypeController  {

	@Autowired
	FieldTypeService fieldTypeService; 
		
	@RequestMapping(value = "/don-oscarito/fieldtype", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<FieldType> getFieldsTypes() {
		// TODO Auto-generated method stub
		return fieldTypeService.findAllFieldsTypes();
	}
	
}
