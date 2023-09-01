package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Orders;
import com.app.entities.Users;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
	List<Orders> findByUserOrdered(Users referenceById);
	
	String deleteByuserOrdered(Users user);

}
