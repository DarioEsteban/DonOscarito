package com.usm.donoscarito.service;

import java.util.List;
import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.ReservationUpdate;

public interface ReservationService {

	public void save(Reservation reservation);
	
	public void cancel(Reservation reservation);
	
	public void update(ReservationUpdate reservationUpdate);
	
	public List<Reservation> findByidUser(Integer idUser);
}
