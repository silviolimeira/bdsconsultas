package com.devsuperior.uri2737.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2737.entities.Lawyer;
import com.devsuperior.uri2737.projections.LawyerMinProjection;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

	
	
	
//	@Query(nativeQuery = true, value = 
//			"SELECT m.id, m.name "
//			+ "FROM movies m "
//			+ "INNER JOIN genres g ON m.id_genres = g.id "
//			+ "where LOWER(g.description) = LOWER(:genreName)")
//		List<MovieMinProjection> search(String genreName);

	
	@Query(nativeQuery = true, value = 
		"(select name, customers_number as customersNumber from lawyers " +
		"where customers_number = (select MAX(customers_number) from lawyers) " +
		") union all " +
		"(select name, customers_number from lawyers " +
		"where customers_number = (select MIN(customers_number) from lawyers)" +
		") union all " +
		"(SELECT 'Average', ROUND(AVG(customers_number), 0) " + 
		"FROM lawyers)")
		List<LawyerMinProjection> queryMaxMinAvg();
	
	
}
