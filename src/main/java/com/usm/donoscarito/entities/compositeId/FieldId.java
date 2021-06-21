package com.usm.donoscarito.entities.compositeId;

import java.io.Serializable; 

public class FieldId implements Serializable {

	private Integer idField;
	
	private Integer idState;
	
	private Integer idType;
	
	public FieldId() {
		
	}

	public FieldId(Integer idField, Integer idState, Integer idType) {
		this.idField = idField;
		this.idState = idState;
		this.idType = idType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idState == null) ? 0 : idState.hashCode());
		result = prime * result + ((idField == null) ? 0 : idField.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
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
		FieldId other = (FieldId) obj;
		if (idState == null) {
			if (other.idState != null)
				return false;
		} else if (!idState.equals(other.idState))
			return false;
		if (idField == null) {
			if (other.idField != null)
				return false;
		} else if (!idField.equals(other.idField))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		return true;
	}

	
}
