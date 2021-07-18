package com.usm.donoscarito.service;

import java.util.Date;
import java.util.List;
import com.usm.donoscarito.entities.Reservation;

public interface ReservationService {

	public void save(Reservation reservation);
	
	public void cancel(Reservation reservation);
	
	public void update(Reservation reservationUpdate);
	
	public List<Reservation> findByidUser(Integer idUser);
	
	public List<Reservation> findByDate(Date date);
}
