package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	/*
	 *
	 * Como de costume o setor de vendas está fazendo uma análise de quantos produtos temos em estoque, 
	 * e você poderá ajudar eles.
	   Então seu trabalho será exibir o nome e a quantidade de produtos de cada uma categoria.
	   
	    
	    Exemplo de saída
		name	sum
		luxury	350
		modern	13000
		wood	850
		vintage	1000 
	 */
	@Override
	public void run(String... args) throws Exception {

		List<CategorySumDTO> list = repository.getSumCategoriesN().stream().map(s -> {
			return new CategorySumDTO(s);
		}).collect(Collectors.toList());
		
		System.out.println(list);
		
		System.out.println("\n\n\nConsulta JPQL");
		
		List<CategorySumDTO> query = repository.getSumCategories();
		
		System.out.println(query);
	}
}
