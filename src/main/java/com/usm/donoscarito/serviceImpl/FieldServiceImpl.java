package com.usm.donoscarito.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.Field;
import com.usm.donoscarito.entities.Reservation;
import com.usm.donoscarito.entities.compositeId.FieldId;
import com.usm.donoscarito.entities.compositeId.ReservationId;
import com.usm.donoscarito.repository.FieldRepository;
import com.usm.donoscarito.service.FieldService;

@Service
public class FieldServiceImpl implements FieldService {

	@Autowired
	FieldRepository fieldRepository;

	@Override
	public void save(Field field) {
		if (!fieldRepository.existsById(new FieldId(field.getIdField(), field.getIdState(), field.getIdType()))) {
			fieldRepository.save(field);
		} else {
			throw new IllegalArgumentException("Ya existe cancha.");
		}
	}
 
	@Override
	public void update(Field field) {
		// Armar PK compuesta
		FieldId fieldId = new FieldId(field.getIdField(), field.getIdState(), field.getIdType());
		// Validar existencia de elemento
		if (fieldRepository.existsById(fieldId)) {
			// Rescatar reserva
			Field fieldToUpdate = fieldRepository.getOne(fieldId); 
			// Configurar clase
			fieldToUpdate.setIdState(field.getIdState()); 
			fieldToUpdate.setIdType(field.getIdType());
			fieldToUpdate.setValue(field.getValue());

			// Modificar
			fieldRepository.save(fieldToUpdate);
		} else {
			throw new IllegalArgumentException("No existe cancha.");
		}
	}

}
