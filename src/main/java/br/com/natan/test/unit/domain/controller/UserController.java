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

import br.com.natan.test.unit.domain.entities.UserTest;
import br.com.natan.test.unit.domain.services.UserService;

@RestController
@RequestMapping(value = "v1/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public List<UserTest> exposeResourceCollection() {
		List<UserTest> userList = service.getResourceCollection();
		return userList;
	}

	@GetMapping(value = "{userCode}")
	public UserTest exposeResource(@PathVariable Long userCode) {
		UserTest user = service.getResourceOrFail(userCode);
		return user;
	}

	@PostMapping
	public UserTest createUser(@RequestBody UserTest userRequest) {
		UserTest userResponse = service.createUser(userRequest);
		return userResponse;
	}

	@PutMapping
	public UserTest updateUser(@RequestBody UserTest userRequest) {
		UserTest userResponse = service.updateUser(userRequest);
		return userResponse;
	}

}
