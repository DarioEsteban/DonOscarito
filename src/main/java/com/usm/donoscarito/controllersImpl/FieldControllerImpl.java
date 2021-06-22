package com.usm.donoscarito.controllersImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ums.donoscarito.controllers.FieldController;
import com.usm.donoscarito.entities.Field;
import com.usm.donoscarito.service.FieldService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController 
@ApiResponses({ 
	@ApiResponse(code = 200, message = "Ok"),
	@ApiResponse(code = 409, message = "Conflict"),
	@ApiResponse(code = 500, message = "Internal Server Error")
	})

@RequestMapping(value = "/field")
public class FieldControllerImpl implements FieldController {

	@Autowired
	FieldService fieldService;
	//private List<Field> aux2;
	
	@ApiOperation(value = "Agregar una cancha.")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces={"application/json"})	
	@Override
	public ResponseEntity<String> addField(@RequestBody Field field) {
		try {
			fieldService.save(field); 
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

	@ApiOperation(value = "Modificar una cancha.")
	@RequestMapping(value = "/update", method = RequestMethod.PATCH, produces={"application/json"})	
	@Override
	public ResponseEntity<String> updateField(@RequestBody Field field) {
		try {
			fieldService.update(field); 
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

	@ApiOperation(value = "Obtener canchas.")
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<Field> getFields() {
		/*List<Field> aux = fieldService.getFields();
		aux2 = null;
		aux.stream().filter(field -> field.getIdState() == 1).map(field -> aux2.add(field));*/
		return fieldService.getFields();
	}

}
