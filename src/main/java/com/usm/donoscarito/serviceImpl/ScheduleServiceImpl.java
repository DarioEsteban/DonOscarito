package com.usm.donoscarito.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.donoscarito.entities.Schedule;
import com.usm.donoscarito.repository.ScheduleRepository;
import com.usm.donoscarito.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Override
	public List<Schedule> findByidFieldInAndDateIn(List<Integer> fields, List<Date> dates) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByidFieldInAndDateIn(fields, dates);
	}

}
