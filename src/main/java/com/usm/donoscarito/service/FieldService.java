package com.usm.donoscarito.service;
 
import java.util.List;

import com.usm.donoscarito.entities.Field; 

public interface FieldService {
	
	public void save(Field field); 
	
	public void update(Field field);
	
	public List<Field> getFields();
	
}
