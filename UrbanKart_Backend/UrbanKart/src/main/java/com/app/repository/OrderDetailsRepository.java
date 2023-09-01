package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.OrderDetails;
import com.app.entities.Orders;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
	void deleteByorderId(Orders Id);
}
