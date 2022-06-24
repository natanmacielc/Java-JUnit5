package br.com.natan.test.unit.domain.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natan.test.unit.domain.entities.Movie;
import br.com.natan.test.unit.domain.exceptions.MovieNotFoundException;
import br.com.natan.test.unit.domain.exceptions.MovieNotFoundException.MovieNotFoundExceptionId;
import br.com.natan.test.unit.domain.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public List<Movie> getResourceCollection() {
		List<Movie> movieList = repository.findAll();

		if (movieList.isEmpty()) {
			throw new MovieNotFoundException();
		}

		return movieList;
	}

	public Movie getResourceOrFail(Long movieCode) {
		Optional<Movie> movieById = repository.findById(movieCode);
		return movieById.orElseThrow(
				() -> new MovieNotFoundException(new MovieNotFoundExceptionId(movieCode)));
	}

	public Movie createMovie(Movie movie) {
		movie.setRegistrationDate(LocalDateTime.now());
		movie.setLastUpdate(LocalDateTime.now());
		movie.setMovieCode(ThreadLocalRandom.current().nextLong());
		return repository.save(movie);
	}

	public Movie updateMovie(Movie newMovie) {
		Optional<Movie> movieById = repository.findById(newMovie.getId());
		return movieById.map(movie -> {
			movie.setName(newMovie.getName());
			movie.setStartDate(newMovie.getStartDate());
			movie.setEndDate(newMovie.getEndDate());
			movie.setMovieCode(ThreadLocalRandom.current().nextLong());
			movie.setRegistrationDate(movieById.get().getRegistrationDate());
			movie.setLastUpdate(LocalDateTime.now());
			return repository.save(movie);
		}).orElseThrow(() -> {
			throw new MovieNotFoundException(new MovieNotFoundExceptionId(
					newMovie.getId()));
		});
	}

}
