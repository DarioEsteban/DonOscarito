package com.usm.donoscarito.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usm.donoscarito.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	/*
	 * Método para buscar el horario para un día y cancha en específico
	 * NOTA: JPA identifica el nombre del método y buscará con eso los datos
	 * Utiliza las palabras IN y AND para separar campos
	 * En este caso es findBy<campoEntity>InAnd<campoEntiry>In
	 * */
	List<Schedule> findByidFieldInAndDateIn(List<Integer> field, List<Date> date);
	
	List<Schedule> findByAvailableIn(List<Boolean> available);
}
