package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	
//	SELECT m.id, m.name
//	FROM movies m
//	INNER JOIN genres g ON m.id_genres = g.id
//	where lower(g.description) = 'action';
	
	@Query(nativeQuery = true, value = 
		"SELECT m.id, m.name "
		+ "FROM movies m "
		+ "INNER JOIN genres g ON m.id_genres = g.id "
		+ "where LOWER(g.description) = LOWER(:genreName)")
	List<MovieMinProjection> getMoviesWithGenreN(String genreName);
	

	@Query(
			"SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(obj.id, obj.name) "
			+ "FROM Movie obj "
			+ "WHERE LOWER(obj.genre.description) = LOWER(:genreName)")
	List<MovieMinDTO> getMoviesWithGenre(String genreName);
	
	
}
