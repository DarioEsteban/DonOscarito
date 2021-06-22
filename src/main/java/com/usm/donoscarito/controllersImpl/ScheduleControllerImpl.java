package com.usm.donoscarito.controllersImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ums.donoscarito.controllers.ScheduleController;
import com.usm.donoscarito.entities.Schedule;
import com.usm.donoscarito.service.ScheduleService;
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
@RequestMapping(value = "/schedule")
public class ScheduleControllerImpl implements ScheduleController {

	/*
	 * Injectamos el service al controlador.
	 * */
	@Autowired
	ScheduleService scheduleService;
	
	/*
	 * Método Get para obtener los bloques de horario para una cancha y día en específico. 
	 * */
	@ApiOperation(value = "Obtener bloques de horarios por cancha y fecha.")
	@RequestMapping(value = "/list/{field}/{date}", method = RequestMethod.GET, produces={"application/json"})	
	@Override
	public List<Schedule> getByFieldDate(@PathVariable Integer field, @PathVariable Date date) {
		/*@PathVariable sirve para enlazar el parámetro pasado en @RequestMapping varaible.*/
		
		/*Crear lista de campos para pasar la variable que viene por parámetro*/
		List<Integer> fieldList = new ArrayList<Integer>();
		fieldList.add(field);
		
		/*Crear lista de fechas para pasar la variable que viene por parámetro*/
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(date);
		
		return scheduleService.findByidFieldInAndDateIn(fieldList, dateList);
	}

	/*
	 * Al probar con swagger, eliminar atributo finalTime e initTime; si se envía provoca error al no saber como parsearlo.
	 * */
	@ApiOperation(value = "Actualizar bloque de horario.")
	@RequestMapping(value = "/update", method = RequestMethod.PATCH, produces={"application/json"})	
	@Override
	public ResponseEntity<String> update(@RequestBody List<Schedule> schedules) {
		//ResponseEntity sirve para responder HttpStatus code.
		try {
			scheduleService.update(schedules);
			return new ResponseEntity<String>("",HttpStatus.OK);
		}
		catch(IllegalArgumentException iex)
		{
			//Cualquier error y mensaje que saquemos que sea así para capturarlo en angular y distingüirlo de un error común.
			return new ResponseEntity<String>("{\"message\":\""+iex.getMessage()+"\"}",HttpStatus.CONFLICT);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("{\"message\":\""+ex.getMessage()+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
