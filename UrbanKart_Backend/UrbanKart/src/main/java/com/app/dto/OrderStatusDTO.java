package com.app.dto;

import java.time.LocalDate;
import com.app.entities.DeliveryAddress;

public class OrderStatusDTO {

	private Long orderId;
	private String status;
	private LocalDate deliveryDate;

	public OrderStatusDTO() {
		super();
	}

	public OrderStatusDTO(Long orderId, String status, LocalDate deliveryDate) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.deliveryDate = deliveryDate;

	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}