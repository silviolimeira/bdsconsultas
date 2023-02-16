package com.devsuperior.uri2611.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.uri2611.projections.MovieMinProjection;

public class MovieMinDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	Long id;
	String name;

	public MovieMinDTO() {
	}

	public MovieMinDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public MovieMinDTO(MovieMinProjection projection)
	{
		id = projection.getId();
		name = projection.getName();
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieMinDTO other = (MovieMinDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MovieGenreDTO [id=" + id + ", name=" + name + "]";
	}

}
