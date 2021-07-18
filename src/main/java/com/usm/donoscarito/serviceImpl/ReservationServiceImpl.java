package com.usm.donoscarito.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.Schedule;
import com.usm.donoscarito.entities.StateReservation;
import com.usm.donoscarito.repository.ReservationRepository;
import com.usm.donoscarito.repository.ScheduleRepository;
import com.usm.donoscarito.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	//Injección
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ScheduleRepository scheduleRepository;
	
	//Permite registrar una reserva
	@Override
	public void save(Reservation reservation) {
		if(!reservationRepository.existsById(reservation.getIdReservation()))
		{
			reservationRepository.save(reservation);
		}
		else {
			throw new IllegalArgumentException("Ya existe una reserva en curso.");
		}
	}

	//Permite anular una reserva
	@Override
	public void cancel(Reservation reservation) {
		//Validar existencia de elemento
		if(reservationRepository.existsById(reservation.getIdReservation()))
		{
			//Rescatar reserva
			Optional<Reservation> reservationFind = reservationRepository.findById(reservation.getIdReservation());
			
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
					
					//Habilitar bloque horario
					Optional<Schedule> scheduleFind = scheduleRepository.findById(reservation.getIdBlock());
					Schedule schedule = scheduleFind.get();
					schedule.setAvailable(true);
					scheduleRepository.save(schedule);
					
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

	//Permite modificar una reserva
	@Override
	public void update(Reservation reservationUpdate) {

		// Verificar que elemento exista en la base de datos
		if(reservationRepository.existsById(reservationUpdate.getIdReservation()))
		{
			//Crear nuevo objeto de reserva que será enviado a la base de datos
			Reservation reservaToUpdate = new Reservation();
			//Buscar objeto en base de datos según ID
			Optional<Reservation> reservationFind = reservationRepository.findById(reservationUpdate.getIdReservation());
			
			if(reservationFind.isPresent()) {
				//RValidar que no contenga pago registrado
				if(reservationFind.get().getPayment() == null)
				{
					reservaToUpdate = reservationFind.get();
					//Mantener ID de bloque horario anterior
					Integer idBlockOld = reservaToUpdate.getIdBlock();
					//Modificar clase con nuevo bloque horario
					reservaToUpdate.setIdBlock(reservationUpdate.getIdBlock());
					//Guardar
					reservationRepository.save(reservaToUpdate);
					
					//Habilitar bloque horario anterior
					Optional<Schedule> scheduleOldFind = scheduleRepository.findById(idBlockOld);
					Schedule scheduleOld = scheduleOldFind.get();
					scheduleOld.setAvailable(true);
					scheduleRepository.save(scheduleOld);
					
					//Bloquear bloque horario nuevo
					Optional<Schedule> scheduleNewFind = scheduleRepository.findById(reservationUpdate.getIdBlock());
					Schedule scheduleNew = scheduleNewFind.get();
					scheduleNew.setAvailable(false);
					scheduleRepository.save(scheduleNew);
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

	//Permite listar las reservas por usuario
	@Override
	public List<Reservation> findByidUser(Integer idUser) {
		return reservationRepository.findByIdUser(idUser);
	}

	//Permite listar las reservas por fecha
	@Override
	public List<Reservation> findByDate(Date date) {
		// TODO Auto-generated method stub
		return reservationRepository.findAllByDate(date);
	}

}
