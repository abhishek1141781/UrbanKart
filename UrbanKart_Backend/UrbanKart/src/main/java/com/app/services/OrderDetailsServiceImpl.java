package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.OrderDetails;
import com.app.repository.OrderDetailsRepository;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository detailsRepository;

	@Override
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
		return detailsRepository.save(orderDetails);
	}
}
