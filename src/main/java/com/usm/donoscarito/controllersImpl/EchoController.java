package com.usm.donoscarito.controllersImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@ApiResponses({ 
	@ApiResponse(code = 200, message = "Ok"),
	@ApiResponse(code = 409, message = "Conflict"),
	@ApiResponse(code = 500, message = "Internal Server Error")
	})
public class EchoController {

	@RequestMapping(value = "/echo", method = RequestMethod.GET, produces={"application/text"})	
    public String Echo() {
        return "Ok";
    }

}
