package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Status;

public class OrdersRespDTO {
	
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private Status status;
	private double totalPrice;
	private double shippingPrice;
	private Long userOrdered;
	private Long address;

	public OrdersRespDTO() {
		super();
	}

	public OrdersRespDTO(LocalDate orderDate, LocalDate deliveryDate, Status status, double totalPrice,
			double shippingPrice, Long userOrdered, Long address) {
		super();
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.totalPrice = totalPrice;
		this.shippingPrice = shippingPrice;
		this.userOrdered = userOrdered;
		this.address = address;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public Long getUserOrdered() {
		return userOrdered;
	}

	public void setUserOrdered(Long userOrdered) {
		this.userOrdered = userOrdered;
	}

	public Long getAddress() {
		return address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

}
