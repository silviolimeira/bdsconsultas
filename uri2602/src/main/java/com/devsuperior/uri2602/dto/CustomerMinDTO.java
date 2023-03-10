package com.devsuperior.uri2602.dto;

import java.util.Objects;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerMinDTO {

	private String name;

	public CustomerMinDTO() {
	}

	public CustomerMinDTO(String name) {
		this.name = name;
	}

	public CustomerMinDTO(CustomerMinProjection projection) {
		name = projection.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMinDTO other = (CustomerMinDTO) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "CustomerMinDTO [name=" + name + "]";
	}

}
