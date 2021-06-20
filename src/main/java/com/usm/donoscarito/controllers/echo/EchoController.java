package com.usm.donoscarito.controllers.echo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping; 

@RestController
public class EchoController {

	@RequestMapping(value = "/echo", method = RequestMethod.GET, produces={"application/text"})	
    public String Echo() {
        return "Ok";
    }
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> getAll(){
		String sql = "select test, test1, test2, test3 from test";
		List<Map<String, Object>> listMapQuery = jdbcTemplate.queryForList(sql);
		List<String> testList = new ArrayList<>();
		listMapQuery.forEach(singer -> testList.add(singer.toString()));
		return testList;
	}

	@GetMapping("/")
	public List<String> query() {
		return getAll();
	}

}
