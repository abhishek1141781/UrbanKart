package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Carts;

public interface CartRepository extends JpaRepository<Carts, Long> {
}
