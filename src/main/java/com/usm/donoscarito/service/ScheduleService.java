package com.usm.donoscarito.service;

import java.sql.Date;
import java.util.List;
import com.usm.donoscarito.entities.Schedule;

public interface ScheduleService {

	public List<Schedule> findByidFieldInAndDateIn(List<Integer> fields, List<Date> dates);
	
	public List<Schedule> findByidFieldInAndAvailableIn(List<Integer> fields,List<Boolean> availables);
	
	public void update(List<Schedule> schedules);
	
}
