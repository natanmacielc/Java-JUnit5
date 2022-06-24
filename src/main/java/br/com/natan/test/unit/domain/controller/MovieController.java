package br.com.natan.test.unit.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.natan.test.unit.domain.entities.Movie;
import br.com.natan.test.unit.domain.services.MovieService;

@RestController
@RequestMapping(value = "v1/movie")
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping
	public List<Movie> exposeResourceCollection() {
		List<Movie> movieList = service.getResourceCollection();
		return movieList;
	}

	@GetMapping(value = "{movieCode}")
	public Movie exposeResourceOrFail(@PathVariable Long movieCode) {
		Movie movie = service.getResourceOrFail(movieCode);
		return movie;
	}

	@PostMapping
	public Movie createMovie(@RequestBody Movie movieRequest) {
		Movie movieResponse = service.createMovie(movieRequest);
		return service.createMovie(movieResponse);
	}

	@PutMapping 
	public Movie updateMovie(@RequestBody Movie movieRequest) {
		Movie movieResponse = service.updateMovie(movieRequest);
		return service.updateMovie(movieResponse);
	}

}
