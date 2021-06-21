package com.usm.donoscarito.controllersImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ums.donoscarito.controllers.ReservationController;
import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.service.ReservationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiResponses({ 
	@ApiResponse(code = 200, message = "Ok"),
	@ApiResponse(code = 409, message = "Conflict"),
	@ApiResponse(code = 500, message = "Internal Server Error")
	})
@RequestMapping(value = "/reservation")
public class ReservationControllerImpl implements ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@ApiOperation(value = "Agregar una reserva.")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces={"application/json"})	
	@Override
	public ResponseEntity<String> addReservation(@RequestBody Reservation reservation) {
		try {
			reservationService.save(reservation);
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
