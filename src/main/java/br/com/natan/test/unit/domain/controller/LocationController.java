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

import br.com.natan.test.unit.domain.entities.Location;
import br.com.natan.test.unit.domain.services.LocationService;

@RestController
@RequestMapping(value = "v1/location")
public class LocationController {

	@Autowired
	private LocationService service;

	@GetMapping
	public List<Location> exposeResourceCollection() {
		List<Location> location = service.getResourceCollection();
		return location;
	}

	@GetMapping(value = "{locationCode}")
	public Location exposeResourceOrFail(@PathVariable Long locationCode) {
		Location location = service.getResourceOrFail(locationCode);
		return location;
	}

	@PostMapping
	public Location createLocation(@RequestBody Location locationRequest) {
		Location locationResponse = service.createLocation(locationRequest);
		return locationResponse;
	}

	@PutMapping
	public Location updateLocation(@RequestBody Location locationRequest) {
		Location locationResponse = service.updateLocation(locationRequest);
		return locationResponse;
	}

}
