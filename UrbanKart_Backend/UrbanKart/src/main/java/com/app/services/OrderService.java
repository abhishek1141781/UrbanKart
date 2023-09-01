package com.app.services;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.DeliveryAddressDTO;
import com.app.dto.OrdersRespDTO;
import com.app.entities.Orders;

public interface OrderService {

	OrdersRespDTO placeOrder(Long userId,DeliveryAddressDTO address);

	List<Orders> getAllOrders();

	List<Orders> getMyOrders(Long Id);

	void deleteOrder(Long orderId);

	void deleteOrders(Long userId);

	void cancelOrder(Long orderId);

	void updateOrderStatus(Long orderId, String status,LocalDate deliveryDate);
	
}
