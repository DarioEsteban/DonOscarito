package com.usm.donoscarito.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usm.donoscarito.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	//Buscar reserva por ID de usuario
	public List<Reservation> findByUserIdUser(Integer idUser);
	
	//Buscar reservas por fecha 
	@Query(value = "SELECT r FROM Reservation r WHERE r.date = CAST(:creationDate as date) ORDER BY r.state.description DESC")
	public List<Reservation> findAllByDate(@Param("creationDate") Date date);
	
}
