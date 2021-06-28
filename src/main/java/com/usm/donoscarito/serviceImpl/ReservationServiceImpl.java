package com.usm.donoscarito.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.ReservationUpdate;
import com.usm.donoscarito.entities.StateReservation;
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
				if(reservationFind.get().getPayment() == null)
				{
					StateReservation state = new StateReservation();
					state.setIdState(2);
					//Configurar clase
					reservationToUpdate.setState(state);
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
	public void update(ReservationUpdate reservationUpdate) {
		//Armar PK compusta
		ReservationId reservationId = new ReservationId(
				reservationUpdate.getReservation().getIdField(), 
				reservationUpdate.getReservation().getIdUser(),
				reservationUpdate.getReservation().getIdBlock(), 
				reservationUpdate.getReservation().getDate());

		if(reservationRepository.existsById(reservationId))
		{
			Reservation reservaToUpdate = new Reservation();
			Optional<Reservation> reservationFind = reservationRepository.findById(reservationId);
			if(reservationFind.isPresent()) {
				//Rescatar reserva
				if(reservationFind.get().getPayment() == null)
				{
					//Configurar clase
					reservaToUpdate.setIdField(reservationFind.get().getIdField());
					reservaToUpdate.setIdBlock(reservationUpdate.getSchedule().getIdSchedule());
					reservaToUpdate.setIdUser(reservationFind.get().getIdUser());
					reservaToUpdate.setDate(reservationFind.get().getDate());
					//reservationToUpdate.setIdPayment(reservationToUpdate.getIdPayment());
					reservaToUpdate.setState(reservationFind.get().getState());
					//Modificar
					reservationRepository.save(reservaToUpdate);
				}
				else {
					throw new IllegalArgumentException("La reserva se encuentra pagada, no se puede modificar.");
				}
			}
					
		}
		else {
			throw new IllegalArgumentException("No existe una reserva con las características seleccionadas.");
		}
		
	}

	@Override
	public List<Reservation> findByidUser(Integer idUser) {
		return reservationRepository.findByIdUser(idUser);
	}

}
