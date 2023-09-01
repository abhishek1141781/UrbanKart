package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DeliveryAddressDTO;
import com.app.dto.OrderStatusDTO;
import com.app.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/user/{userId}")
	public ResponseEntity<?> placeOrder(@PathVariable Long userId, @RequestBody DeliveryAddressDTO address) {

		return new ResponseEntity<>(orderService.placeOrder(userId, address), HttpStatus.CREATED);
	}

	@GetMapping("/admin")
	public ResponseEntity<?> getAllOrders() {
		return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.CREATED);
	}

	@GetMapping("/user/{custId}")
	public ResponseEntity<?> getMyOrders(@PathVariable Long custId) {
		return new ResponseEntity<>(orderService.getMyOrders(custId), HttpStatus.CREATED);
	}

	@PutMapping("/user/cancel/{orderId}") // User
	public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
		System.out.println("In Order Cancel ");
		orderService.cancelOrder(orderId);
		return new ResponseEntity<String>("Order Deleted", HttpStatus.CREATED);
	}

	@DeleteMapping("user/{userId}") // User
	public ResponseEntity<String> deleteOrders(@PathVariable Long userId) {

		orderService.deleteOrders(userId);
		return new ResponseEntity<String>("Order Deleted", HttpStatus.CREATED);
	}

	@PutMapping("/admin")
	public ResponseEntity<String> updateOrderStatus(@RequestBody OrderStatusDTO order) {
		orderService.updateOrderStatus(order.getOrderId(), order.getStatus(), order.getDeliveryDate());
		return new ResponseEntity<String>("Order Deleted", HttpStatus.CREATED);
	}

}
