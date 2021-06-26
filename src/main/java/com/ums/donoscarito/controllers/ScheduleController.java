package com.ums.donoscarito.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.usm.donoscarito.entities.Schedule;

public interface ScheduleController {

	public List<Schedule> getByFieldDateAvailable(Integer field, Date date, Boolean available); 
	
	public ResponseEntity<String> update(Schedule schedule);
}
