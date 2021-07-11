package com.usm.donoscarito.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usm.donoscarito.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	//Buscar reserva por ID de usuario
	public List<Reservation> findByIdUser(Integer idUser);
	
}
