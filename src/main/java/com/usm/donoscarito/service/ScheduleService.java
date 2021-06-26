package com.usm.donoscarito.service;

import java.sql.Date;
import java.util.List;
import com.usm.donoscarito.entities.Schedule;

public interface ScheduleService {

	public List<Schedule> findByidFieldInAndDateInAndAvailableIn(Integer field, Date date, Boolean available);
	 
	public void update(Schedule schedule);
	
}
