package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<EmpregadoDeptDTO> list = repository.queryNaoAlocadosN().stream().map(d -> new EmpregadoDeptDTO(d))
				.collect(Collectors.toList());

		System.out.println(list);

		System.out.println("JPQL - Lista empregados não alocados ordenados por cpf");

		List<EmpregadoDeptDTO> query = repository.queryNaoAlocados();

		System.out.println(query);

	}
}
