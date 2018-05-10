package com.epam.newsmanagement.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mikhail_Sadouski
 *
 *         <p>
 *         Author transfer object. Represents Author table in database
 *         </p>
 */
public class Author implements Serializable {

	private static final long serialVersionUID = 1240898491978542955L;
	private Long id;
	private String name;
	private Date expired;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expired == null) ? 0 : expired.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (expired == null) {
			if (other.expired != null)
				return false;
		} else if (!expired.equals(other.expired))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Author{").append("id=").append(id)
				.append(", name='").append(name).append('\'')
				.append(", expired=").append(expired).append('}').toString();
	}

}
