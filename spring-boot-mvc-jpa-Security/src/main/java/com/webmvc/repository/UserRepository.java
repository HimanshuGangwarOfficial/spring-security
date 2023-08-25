package com.webmvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webmvc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmailAddress(String emailAddress);
}
