package com.usm.donoscarito.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cancha")
public class Field {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cancha")
	private Integer idField;
	
	@OneToOne
    @JoinColumn(name  = "id_estado_cancha")
	private StateField stateField;
	
	@ManyToOne
    @JoinColumn(name  = "id_tipo_cancha")
	private FieldType fieldType;
	
	@Column(name="valor_bloque")
	private Integer amount;

	public Integer getIdField() {
		return idField;
	}

	public void setIdField(Integer idField) {
		this.idField = idField;
	}

	public StateField getStateField() {
		return stateField;
	}

	public void setStateField(StateField stateField) {
		this.stateField = stateField;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
	
}
