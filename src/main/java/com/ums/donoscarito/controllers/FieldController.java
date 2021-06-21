package com.ums.donoscarito.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.usm.donoscarito.entities.Field; 

public interface FieldController {

	public ResponseEntity<String> addField(Field field);
	
	public ResponseEntity<String> updateField(Field field);
	
	public List<Field> getFields();
	
}
