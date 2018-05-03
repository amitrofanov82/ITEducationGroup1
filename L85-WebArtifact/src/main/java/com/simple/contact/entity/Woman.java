package com.simple.contact.entity;

public class Woman {
	
	private long id;
	private Contact husband;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((husband == null) ? 0 : husband.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Woman other = (Woman) obj;
		if (husband == null) {
			if (other.husband != null)
				return false;
		} else if (!husband.equals(other.husband))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
