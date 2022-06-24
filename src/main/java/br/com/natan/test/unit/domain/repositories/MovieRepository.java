package br.com.natan.test.unit.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.natan.test.unit.domain.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
