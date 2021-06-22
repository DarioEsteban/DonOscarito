package com.usm.donoscarito.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.Field;
import com.usm.donoscarito.repository.FieldRepository;
import com.usm.donoscarito.service.FieldService;

@Service
public class FieldServiceImpl implements FieldService {

	@Autowired
	FieldRepository fieldRepository;

	@Override
	public void save(Field field) {
		fieldRepository.save(field);
	}
 
	@Override
	public void update(Field field) {
		// Armar PK compuesta
		// Validar existencia de elemento
		if (fieldRepository.existsById(field.getIdField())) {
			// Rescatar reserva
			Field fieldToUpdate = fieldRepository.getOne(field.getIdField()); 
			// Configurar clase
			//fieldToUpdate.setIdState(field.getIdState()); 
			fieldToUpdate.setFieldType(field.getFieldType());
			fieldToUpdate.setAmount(field.getAmount());
			// Modificar
			fieldRepository.save(fieldToUpdate);
		} else {
			throw new IllegalArgumentException("No existe cancha.");
		}
	}

	@Override
	public List<Field> getFields() {
		// TODO Auto-generated method stub
		return fieldRepository.findAll();
	}

}
