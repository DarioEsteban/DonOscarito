package com.usm.donoscarito.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
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
	public List<Schedule> findByidFieldInAndDateIn(List<Integer> fields, List<Date> dates) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByidFieldInAndDateIn(fields, dates);
	}

	/*
	 * Actualizar registros de Horario
	 * */
	@Override
	public void update(List<Schedule> schedules) {
		List<Schedule> schedulesToUpdate = new ArrayList<Schedule>();
		
		/*Recorrer lista en busca de horarios inconsistentes para evitar modificar y después tener otro con problemas*/
		schedules.forEach((f) -> {
			int id = f.getIdSchedule();			
			/*Validar existencia del horario*/
			if (!scheduleRepository.existsById(id))
			{
				throw new IllegalArgumentException("No se ha encontrado el bloque de horario id="+id+".");
			}
			Optional<Schedule> scheduleFind = scheduleRepository.findById(id);
			/*Validar que esté disponible*/
			if(scheduleFind.isPresent()) {
				/*Ejecuta la condición sólo si es para arrendar*/
				if (!schedules.get(0).getAvailable())
				{
					if(!scheduleFind.get().getAvailable())
						throw new IllegalArgumentException("Bloque de horario id="+id+" no está disponible.");
				}
				schedulesToUpdate.add(scheduleFind.get());
			}			
		});
		
		/*Recorrer lista para actualizar*/
		try {
			schedulesToUpdate.forEach((f) -> {
				Schedule scheduleToUpdate = new Schedule();
				scheduleToUpdate.setIdSchedule(f.getIdSchedule());
				scheduleToUpdate.setIdField(f.getIdField());			
				scheduleToUpdate.setDate(f.getDate());
				scheduleToUpdate.setInitTime(f.getInitTime());
				scheduleToUpdate.setFinalTime(f.getFinalTime());
				scheduleToUpdate.setAvailable(!f.getAvailable());
				scheduleRepository.save(scheduleToUpdate);
			});
		}
		catch(IllegalArgumentException iex) {			
			throw new IllegalArgumentException("Error al actualizar los bloques de horarios.");
		};
	}

	@Override
	public List<Schedule> findByAvailableIn(List<Boolean> availables) {
		// TODO Auto-generated method stub
		return scheduleRepository.findByAvailableIn(availables);
	}
}
