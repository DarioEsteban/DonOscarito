package com.ums.donoscarito.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.usm.donoscarito.entities.Reservation;

public interface ReservationController {

	public ResponseEntity<String> addReservation(Reservation reservation);
	
	public ResponseEntity<String> cancelReservation(Reservation reservation);
	
	public ResponseEntity<String> updateReservation(Reservation reservation);
	
	public List<Reservation> getReservationsByUser(Integer idUser);
}
