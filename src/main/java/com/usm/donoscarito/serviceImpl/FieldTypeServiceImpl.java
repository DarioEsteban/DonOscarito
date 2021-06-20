package com.usm.donoscarito.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.donoscarito.entities.FieldType;
import com.usm.donoscarito.repository.FieldTypeRepository;
import com.usm.donoscarito.service.FieldTypeService;

@Service
public class FieldTypeServiceImpl implements FieldTypeService {

	@Autowired
	FieldTypeRepository fieldTypeRepository;

	@Override
	public List<FieldType> findAllFieldsTypes() {
		// TODO Auto-generated method stub
		return fieldTypeRepository.findAll();
	}
	
	
}
