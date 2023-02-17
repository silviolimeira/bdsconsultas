package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		List<ProductMinProjection> list = repository.getProjectionP(10, 20, "P");
//		List<ProductMinDTO> result = list.stream().map(p -> new ProductMinDTO(p)).collect(Collectors.toList());
		
		List<ProductMinDTO> result = repository.getProjection(10, 20, "P");
	
		System.out.println(result.toString());
	}
}
