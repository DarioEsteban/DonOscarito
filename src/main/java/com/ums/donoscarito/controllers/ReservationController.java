package com.ums.donoscarito.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.ReservationUpdate;

public interface ReservationController {

	public ResponseEntity<String> addReservation(Reservation reservation);
	
	public ResponseEntity<String> cancelReservation(Reservation reservation);
	
	public ResponseEntity<String> updateReservation(ReservationUpdate reservationUpdate);
	
	public List<Reservation> getReservationsByUser(Integer idUser);
}
