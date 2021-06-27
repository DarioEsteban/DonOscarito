package com.usm.donoscarito.entities.compositeId;

import java.io.Serializable;
import java.util.Date;

public class ScheduleId implements Serializable {
	
	private Integer idField;
	 
	private Integer idSchedule;
	
	public ScheduleId() {
		
	}

	public ScheduleId(Integer idField, Integer idSchedule, Date date) {
		this.idField = idField;
		this.idSchedule = idSchedule; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idField == null) ? 0 : idField.hashCode());
		result = prime * result + ((idSchedule == null) ? 0 : idSchedule.hashCode());
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
		ScheduleId other = (ScheduleId) obj;
		if (idField == null) {
			if (other.idField != null)
				return false;
		} else if (!idField.equals(other.idField))
			return false;
		if (idSchedule == null) {
			if (other.idSchedule != null)
				return false;
		} else if (!idSchedule.equals(other.idSchedule))
			return false;
		return true;
	}
}
