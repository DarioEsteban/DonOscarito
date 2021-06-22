package com.usm.donoscarito.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_cancha")
public class StateField {
	
	@Id
	@Column(name = "id_estado_cancha")
	private int idStateField;
	
	@Column(name = "descripcion")
	private String description;
	
	public int getIdStateField() {
		return idStateField;
	}
	public void setIdStateField(int idStateField) {
		this.idStateField = idStateField;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
