package com.usm.donoscarito.service;

import com.usm.donoscarito.entities.Reservation;

public interface ReservationService {

	public void save(Reservation reservation);
	
	public void cancel(Reservation reservation);
	
	public void update(Reservation reservation);
	
}
