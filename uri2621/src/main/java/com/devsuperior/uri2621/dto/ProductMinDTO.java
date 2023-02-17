package com.devsuperior.uri2621.dto;

import java.util.Objects;

import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductMinDTO {

	private String name;

	public ProductMinDTO() {
	}
	
	public ProductMinDTO(ProductMinProjection projection) {
		name = projection.getName();
	}

	public ProductMinDTO(String name) {
		super();
		this.name = name;
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
		ProductMinDTO other = (ProductMinDTO) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ProductMinDTO [name=" + name + "]";
	}

}
