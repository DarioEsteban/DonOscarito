package com.usm.donoscarito.serviceImpl;

import java.util.List;
import java.util.Optional;

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
			Optional<Field> fieldToUpdate = fieldRepository.findById(field.getIdField());
			if(fieldToUpdate.isPresent()) {
				// Configurar clase
				Field fieldUpdate = fieldToUpdate.get();
				//fieldToUpdate.setIdState(field.getIdState()); 
				fieldUpdate.setFieldType(field.getFieldType());
				fieldUpdate.setAmount(field.getAmount());
				// Modificar
				fieldRepository.save(fieldUpdate);
			}
			
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
