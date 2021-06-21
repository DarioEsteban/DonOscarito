package com.usm.donoscarito.controllersImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@RequestMapping(value = "/don-oscarito/echo", method = RequestMethod.GET, produces={"application/text"})	
    public String Echo() {
        return "Ok";
    }

}
