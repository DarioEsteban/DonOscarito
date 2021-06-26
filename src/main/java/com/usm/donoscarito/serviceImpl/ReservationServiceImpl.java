package com.usm.donoscarito.serviceImpl;

import java.util.Optional;

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
		if(!reservationRepository.existsById(new ReservationId(reservation.getIdField(), reservation.getIdUser(), reservation.getIdBlock(), reservation.getDate())))
		{
			reservationRepository.save(reservation);
		}
		else {
			throw new IllegalArgumentException("Ya existe una reserva en curso.");
		}
	}

	@Override
	public void cancel(Reservation reservation) {
		//Armar PK compuesta
		ReservationId reservationId = new ReservationId(reservation.getIdField(), reservation.getIdUser(), reservation.getIdBlock(), reservation.getDate());
		//Validar existencia de elemento
		if(reservationRepository.existsById(reservationId))
		{
			//Rescatar reserva
			Optional<Reservation> reservationFind = reservationRepository.findById(reservationId);
			
			if(reservationFind.isPresent()) {
				Reservation reservationToUpdate = reservationFind.get();
				//Validar que no contenga pago
				if(reservationToUpdate.getIdPayment() == null) {
					//Configurar clase
					reservationToUpdate.setIdState(2);
					reservationToUpdate.setDate(reservation.getDate());	
					//Anular
					reservationRepository.save(reservationToUpdate);
				}
				else {
					throw new IllegalArgumentException("La reserva se encuentra pagada, no se puede anular.");
				}
			}
			
		}
		else {
			throw new IllegalArgumentException("No existe una reserva con las características seleccionadas.");
		}
	}

	@Override
	public void update(Reservation reservation) {
		//Armar PK compusta
		ReservationId reservationId = new ReservationId(reservation.getIdField(), reservation.getIdUser(),reservation.getIdBlock(), reservation.getDate());
		
		if(reservationRepository.existsById(reservationId))
		{
			//Rescatar reserva
			Optional<Reservation> reservationFind = reservationRepository.findById(reservationId);
			
			if(reservationFind.isPresent()) {
				Reservation reservationToUpdate = reservationFind.get();
				//Configurar clase
				reservationToUpdate.setDate(reservation.getDate());
				reservationToUpdate.setIdBlock(reservation.getIdBlock()); 
				
				if(reservation.getIdPayment() != null)
					reservationToUpdate.setIdState(reservation.getIdPayment());
				
				//Modificar
				reservationRepository.save(reservationToUpdate);
			}			
		}
		else {
			throw new IllegalArgumentException("No existe una reserva con las características seleccionadas.");
		}
		
	}

}
