package com.usm.donoscarito.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario_disponible")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_horario")
	private int idSchedule;

	@Column(name="id_cancha")
	private int idField;

	@Column(name="fecha")
	private Date date;
	
	@Column(name="bloque_inicio")
	private Time initTime;
	
	
	@Column(name="bloque_fin")
	private Time finalTime;
	
	
	@Column(name="estado")
	private Boolean available;


	public int getIdSchedule() {
		return idSchedule;
	}


	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}


	public int getIdField() {
		return idField;
	}


	public void setIdField(int idField) {
		this.idField = idField;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getInitTime() {
		return initTime;
	}


	public void setInitTime(Time initTime) {
		this.initTime = initTime;
	}


	public Time getFinalTime() {
		return finalTime;
	}


	public void setFinalTime(Time finalTime) {
		this.finalTime = finalTime;
	}


	public Boolean getStatus() {
		return available;
	}


	public void setStatus(Boolean status) {
		this.available = status;
	}
	
	
} 
