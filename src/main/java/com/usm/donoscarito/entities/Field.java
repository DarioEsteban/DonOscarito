package com.usm.donoscarito.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.usm.donoscarito.entities.compositeId.FieldId; 

@Entity
@IdClass(FieldId.class)
@Table(name = "cancha")
public class Field {
	
	@Id
	@Column(name="id_cancha")
	private Integer idField;
	
	@Id
	@Column(name="id_estado_cancha")
	private Integer idState;
	
	@Id
	@Column(name="id_tipo_cancha")
	private Integer idType; 
	
	@Column(name="valor_bloque")
	private Integer value;

	public Integer getIdField() {
		return idField;
	}

	public void setIdField(Integer idField) {
		this.idField = idField;
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
