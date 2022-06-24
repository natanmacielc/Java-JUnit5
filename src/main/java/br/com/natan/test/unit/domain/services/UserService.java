package br.com.natan.test.unit.domain.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natan.test.unit.domain.entities.UserTest;
import br.com.natan.test.unit.domain.exceptions.UserNotFoundException;
import br.com.natan.test.unit.domain.exceptions.UserNotFoundException.UserNotFoundExceptionId;
import br.com.natan.test.unit.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserTest> getResourceCollection() {
		List<UserTest> userList = repository.findAll();

		if (userList.isEmpty()) {
			throw new UserNotFoundException();
		}

		return userList;
	}

	public UserTest getResourceOrFail(Long userCode) {
		Optional<UserTest> userById = repository.findById(userCode);

		return userById.orElseThrow(
				() -> new UserNotFoundException(
						new UserNotFoundExceptionId(userCode)));
	}

	public UserTest createUser(UserTest user) {
		user.setRegistrationDate(LocalDateTime.now());
		user.setLastUpdate(LocalDateTime.now());
		user.setUserCode(ThreadLocalRandom.current().nextLong());
		return repository.save(user);
	}

	public UserTest updateUser(UserTest newUser) {
		Optional<UserTest> userById = repository.findById(newUser.getId());
		return userById.map(user -> {
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setBirthDate(newUser.getBirthDate());
			user.setUserCode(ThreadLocalRandom.current().nextLong());
			user.setRegistrationDate(userById.get().getRegistrationDate());
			user.setLastUpdate(LocalDateTime.now());
			return repository.save(user);
		}).orElseThrow(() -> {
			throw new UserNotFoundException(
					new UserNotFoundExceptionId(newUser.getId()));
		});
	}

}
