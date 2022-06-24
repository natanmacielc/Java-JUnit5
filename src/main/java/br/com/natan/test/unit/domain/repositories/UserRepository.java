package br.com.natan.test.unit.domain.repositories;

import br.com.natan.test.unit.domain.entities.UserTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTest, Long> {

}
