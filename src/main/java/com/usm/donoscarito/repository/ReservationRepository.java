package com.usm.donoscarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.compositeId.ReservationId;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

	
	
}
