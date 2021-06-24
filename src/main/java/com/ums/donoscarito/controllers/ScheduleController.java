package com.ums.donoscarito.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.usm.donoscarito.entities.Schedule;

public interface ScheduleController {

	public List<Schedule> getByFieldDate(Integer field, Date date);
	
	public List<Schedule> getByAvailable(Boolean available);
	
	public ResponseEntity<String> update(List<Schedule> schedules);
}
