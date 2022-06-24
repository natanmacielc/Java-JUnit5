package br.com.natan.test.unit.domain.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natan.test.unit.domain.entities.Location;
import br.com.natan.test.unit.domain.exceptions.LocationNotFoundException;
import br.com.natan.test.unit.domain.exceptions.LocationNotFoundException.LocationNotFoundExceptionId;
import br.com.natan.test.unit.domain.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository repository;

	public List<Location> getResourceCollection() {
		List<Location> locationList = repository.findAll();

		if (locationList.isEmpty()) {
			throw new LocationNotFoundException();
		}

		return locationList;
	}

	public Location getResourceOrFail(Long locationCode) {
		Optional<Location> locationById = repository.findById(locationCode);
		return locationById.orElseThrow(() -> new LocationNotFoundException(
				new LocationNotFoundException.LocationNotFoundExceptionId(locationCode)));
	}

	public Location createLocation(Location location) {
		location.setRegistrationDate(LocalDateTime.now());
		location.setLastUpdate(LocalDateTime.now());
		location.setLocationCode(ThreadLocalRandom.current().nextLong())
;		return repository.save(location);
	}

	public Location updateLocation(Location newLocation) {
		Optional<Location> locationById = repository.findById(newLocation.getId());
		return locationById.map(location -> {
			location.setLocationCode(ThreadLocalRandom.current().nextLong());
			location.setMovie(newLocation.getMovie());
			location.setUserTest(newLocation.getUserTest());
			location.setStartDate(newLocation.getStartDate());
			location.setEndDate(newLocation.getEndDate());
			location.setRegistrationDate(locationById.get().getRegistrationDate());
			location.setLastUpdate(LocalDateTime.now());
			return repository.save(location);
		}).orElseThrow(() -> {
			throw new LocationNotFoundException(new LocationNotFoundExceptionId(
					newLocation.getId()));
		});
	}

}
