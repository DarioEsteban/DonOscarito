package com.usm.donoscarito.controllers.echo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@RequestMapping(value = "/custom", method = RequestMethod.GET, produces={"application/json"})	
    public String Echo() {
        return "Ok";
    }
	
}
