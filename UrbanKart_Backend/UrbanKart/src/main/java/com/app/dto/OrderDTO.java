package com.app.dto;

import com.app.entities.DeliveryAddress;

public class OrderDTO {

	private DeliveryAddress address;

	public OrderDTO() {
		super();
	}

	public OrderDTO(DeliveryAddress address) {
		super();
		this.address = address;
	}

	public DeliveryAddress getAddress() {
		return address;
	}

	public void setAddress(DeliveryAddress address) {
		this.address = address;
	}

}
