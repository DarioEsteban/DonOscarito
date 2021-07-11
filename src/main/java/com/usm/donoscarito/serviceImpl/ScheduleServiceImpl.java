package com.usm.donoscarito.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.Schedule;
import com.usm.donoscarito.repository.ScheduleRepository;
import com.usm.donoscarito.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;
	
	/*
	 * Listar horarios para una cancha y fecha
	 * */
	@Override
	public List<Schedule> findByidFieldInAndDateInAndAvailableIn(Integer field, Date date, Boolean available) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByidFieldAndDateAndAvailable(field, date, available);
	}

	/*
	 * Actualizar registros de Horario
	 * */
	@Override
	public void update(Schedule schedule) {
		try {
			//Buscar horario según ID
			Optional<Schedule> scheduleFind = scheduleRepository.findById(schedule.getIdSchedule());
			Schedule scheduleToUpdate = scheduleFind.get();
			//Deshabilitar bloque
			scheduleToUpdate.setAvailable(false);
			//Guardar cambios
			scheduleRepository.save(scheduleToUpdate);
		}
		catch(IllegalArgumentException iex) {			
			throw new IllegalArgumentException("Error al actualizar los bloques de horarios.");
		};
	}
 
}
