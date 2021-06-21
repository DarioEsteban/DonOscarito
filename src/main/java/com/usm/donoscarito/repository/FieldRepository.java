package com.usm.donoscarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usm.donoscarito.entities.Field;
import com.usm.donoscarito.entities.compositeId.FieldId;

public interface FieldRepository extends JpaRepository<Field, FieldId> {

}
