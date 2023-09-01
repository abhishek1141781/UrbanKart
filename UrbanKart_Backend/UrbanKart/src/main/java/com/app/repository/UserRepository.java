package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Users;

public interface UserRepository extends JpaRepository<Users,Long> {
	Optional<Users> findByEmail(String email);
}
