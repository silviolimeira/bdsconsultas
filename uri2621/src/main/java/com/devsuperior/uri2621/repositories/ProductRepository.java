package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
//	SELECT p.name FROM products p
//	LEFT JOIN providers pv ON p.id_providers = pv.id
//	WHERE (p.amount BETWEEN '10' AND '20')
//	AND pv.name LIKE 'P%';
	
	
	@Query(nativeQuery = true, value =
		"SELECT p.name FROM products p "
		+ "INNER JOIN providers pv ON p.id_providers = pv.id "
		+ "WHERE p.amount BETWEEN :min AND :max "
		+ "AND pv.name LIKE CONCAT(:beginName,'%')")
		List<ProductMinProjection> getProjectionN(Integer min, Integer max, String beginName);
	
	
	@Query(
			"SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) FROM Product obj "
			+ "WHERE obj.amount BETWEEN :min AND :max "
			+ "AND obj.provider.name LIKE CONCAT(:beginName,'%')")
			List<ProductMinDTO> getProjection(Integer min, Integer max, String beginName);
	
}
