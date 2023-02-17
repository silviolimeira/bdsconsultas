package com.devsuperior.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.entities.Category;
import com.devsuperior.uri2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//	 select categories.name, sum(products.amount)
//	 from categories
//	 inner join products on categories.id = products.id_categories
//	 group by categories.name;
	
	@Query(nativeQuery = true, value = 
			"SELECT c.name, SUM(p.amount) "
			+ "FROM categories c "
			+ "INNER JOIN products p ON c.id = p.id_categories "
			+ "GROUP BY c.name")
	List<CategorySumProjection> getSumCategoriesN();

	@Query( 
			"SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(p.category.name, SUM(p.amount)) "
			+ "FROM Product p "
			+ "GROUP BY p.category.name"
			)
	List<CategorySumDTO> getSumCategories();
	
	
}
