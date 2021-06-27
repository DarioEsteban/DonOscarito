package com.usm.donoscarito.entities;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
 
import com.usm.donoscarito.entities.compositeId.ScheduleId;

@Entity
@IdClass(ScheduleId.class)
@Table(name = "horario_disponible")
public class Schedule {
	
	@Id
	@Column(name="id_bloque")
	private Integer idSchedule;

	@Id
	@Column(name="id_cancha")
	private Integer idField;

	@Id
	@Column(name="fecha")
	private Date date;
	
	@Column(name="bloque_inicio")
	private Time initTime;

	@Column(name="bloque_fin")
	private Time finalTime;
		
	@Column(name="estado")
	private Boolean available;


	public Integer getIdSchedule() {
		return idSchedule;
	}


	public void setIdSchedule(Integer idSchedule) {
		this.idSchedule = idSchedule;
	}


	public Integer getIdField() {
		return idField;
	}


	public void setIdField(Integer idField) {
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


	public Boolean getAvailable() {
		return available;
	}


	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
} 
