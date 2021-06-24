package com.usm.donoscarito.entities.compositeId;

import java.io.Serializable;
import java.util.Date;

public class ReservationId implements Serializable {
	
	private Integer idField;
	
	private Integer idUser;
	
	private Integer idBlock;
	
	private Date date;
	
	public ReservationId() {
		
	}

	public ReservationId(Integer idField, Integer idUser, Integer idBlock, Date date) {
		this.idField = idField;
		this.idUser = idUser;
		this.idBlock = idBlock;
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idField == null) ? 0 : idField.hashCode());
		result = prime * result + ((idBlock == null) ? 0 : idBlock.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationId other = (ReservationId) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idField == null) {
			if (other.idField != null)
				return false;
		} else if (!idField.equals(other.idField))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
	
	
	
	
}
