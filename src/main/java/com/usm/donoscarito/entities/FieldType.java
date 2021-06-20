package com.usm.donoscarito.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_cancha")
public class FieldType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_cancha")
	private int idFieldType;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="capacidad")
	private int capacity;
	
	public int getIdFieldType() {
		return idFieldType;
	}
	
	public void setIdFieldType(int idFieldType) {
		this.idFieldType = idFieldType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
