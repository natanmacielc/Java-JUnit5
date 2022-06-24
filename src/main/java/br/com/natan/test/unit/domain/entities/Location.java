package br.com.natan.test.unit.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long LocationCode;
	
	@OneToOne
	@JoinColumn(name="user")
	private UserTest user;
	
	@OneToMany
	@JoinColumn(name="movie")
	private List<Movie> movie;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime registrationDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime lastUpdate;

	public Location() {}

	public Location(Long id, Long locationCode, UserTest user, List<Movie> movie, LocalDate startDate, LocalDate endDate,
			LocalDateTime registrationDate, LocalDateTime lastUpdate) {
		this.id = id;
		LocationCode = locationCode;
		this.user = user;
		this.movie = movie;
		this.startDate = startDate;
		this.endDate = endDate;
		this.registrationDate = registrationDate;
		this.lastUpdate = lastUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocationCode() {
		return LocationCode;
	}

	public void setLocationCode(Long locationCode) {
		LocationCode = locationCode;
	}

	public UserTest getUserTest() {
		return user;
	}

	public void setUserTest(UserTest user) {
		this.user = user;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public LocalDateTime getLastUpdate() {
		return this.lastUpdate;
	}
	
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
