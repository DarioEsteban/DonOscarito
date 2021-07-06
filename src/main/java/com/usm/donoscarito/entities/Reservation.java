package com.usm.donoscarito.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.usm.donoscarito.entities.compositeId.ReservationId;

@Entity
@IdClass(ReservationId.class)
@Table(name = "reserva")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private Integer idReservation;
	
	@Id
	@Column(name="id_cancha")
	private Integer idField;
	
	@Id
	@Column(name="id_usuario")
	private Integer idUser;
	
	@Id
	@Column(name="id_bloque")
	private Integer idBlock;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Id
	@Column(name="fecha_reserva")
	private Date date;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pago")
	private Payment payment;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_reserva")
	private StateReservation state;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cancha", insertable = false, updatable = false)
	private Field field;
 
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
    	@JoinColumn(name = "id_bloque", insertable = false, updatable = false),
    	@JoinColumn(name = "id_cancha", insertable = false, updatable = false)
    })
	private Schedule schedule;

	public Integer getIdReservation() {
		return getIdReservation();
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}
	
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

	public Integer getIdBlock() {
		return idBlock;
	}

	public void setIdBlock(Integer idBlock) {
		this.idBlock = idBlock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public StateReservation getState() {
		return state;
	}

	public void setState(StateReservation state) {
		this.state = state;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}
