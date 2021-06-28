package com.usm.donoscarito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.compositeId.ReservationId;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

	public List<Reservation> findByIdUser(Integer idUser);
	
}
