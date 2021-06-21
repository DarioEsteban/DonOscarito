package com.usm.donoscarito.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.usm.donoscarito.entities.compositeId.ReservationId;

@Entity
@IdClass(ReservationId.class)
@Table(name = "reserva")
public class Reservation {
	
	@Id
	@Column(name="id_cancha")
	private Integer idField;
	
	@Id
	@Column(name="id_usuario")
	private Integer idUser;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Id
	@Column(name="fecha_reserva")
	private Date date;
	
	@Column(name="id_pago")
	private Integer idPayment;
	
	@Column(name="id_estado_reserva")
	private Integer idState;
	
	@Column(name="bloque_inicio")
	private Integer initTime;
	
	@Column(name="bloque_fin")
	private Integer finalTime;

	public Integer getIdField() {
		return idField;
	}

	public void setIdField(Integer idField) {
		this.idField = idField;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public Integer getInitTime() {
		return initTime;
	}

	public void setInitTime(Integer initTime) {
		this.initTime = initTime;
	}

	public Integer getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Integer finalTime) {
		this.finalTime = finalTime;
	}
}
