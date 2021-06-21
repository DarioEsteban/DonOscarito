package com.ums.donoscarito.controllers;

import org.springframework.http.ResponseEntity;

import com.usm.donoscarito.entities.Reservation;

public interface ReservationController {

	public ResponseEntity<String> addReservation(Reservation reservation);
	
	public ResponseEntity<String> cancelReservation(Reservation reservation);
	
}
