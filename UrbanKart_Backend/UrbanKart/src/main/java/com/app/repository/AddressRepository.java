package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.DeliveryAddress;
import com.app.entities.Orders;

public interface AddressRepository extends JpaRepository<DeliveryAddress, Long>{

}
