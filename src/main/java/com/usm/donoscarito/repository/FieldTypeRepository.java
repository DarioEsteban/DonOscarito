package com.usm.donoscarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usm.donoscarito.entities.FieldType;

public interface FieldTypeRepository extends JpaRepository<FieldType, Integer> {
	
}
