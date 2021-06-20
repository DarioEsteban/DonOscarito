package com.ums.donoscarito.controllers;

import java.sql.Date;
import java.util.List;

import com.usm.donoscarito.entities.Schedule;

public interface ScheduleController {

	public List<Schedule> getByFieldDate(Integer field, Date date);
}
