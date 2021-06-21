package com.usm.donoscarito.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.compositeId.ReservationId;
import com.usm.donoscarito.repository.ReservationRepository;
import com.usm.donoscarito.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public void save(Reservation reservation) {
		if(!reservationRepository.existsById(new ReservationId(reservation.getIdField(), reservation.getIdUser(),reservation.getDate())))
		{
			reservationRepository.save(reservation);
		}
		else {
			throw new IllegalArgumentException("Ya existe una reserva en curso.");
		}
	}

}
