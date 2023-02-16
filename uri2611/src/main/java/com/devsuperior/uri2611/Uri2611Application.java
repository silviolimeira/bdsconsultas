package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> projectionNative = movieRepository.getMoviesWithGenreN("Action");

		projectionNative.stream().map(p -> {
			MovieMinDTO m = new MovieMinDTO(p);
			System.out.println(m.toString());
			return m;
		}).collect(Collectors.toList());
		
		System.out.println("\n\n\nRESULTADO JPQL:");
		
		List<MovieMinDTO> query = movieRepository.getMoviesWithGenre("Action");

		query.stream().map(m -> {
			System.out.println(m.toString());
			return m;
		}).collect(Collectors.toList());
		

	}
}
