package com.aurionpro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aurionpro.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	 Optional<User> findByUsername(String username);
}