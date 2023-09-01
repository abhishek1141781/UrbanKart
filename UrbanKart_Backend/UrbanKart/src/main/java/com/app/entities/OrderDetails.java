package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Valid
@Entity
@Table(name="order_details")
public class OrderDetails extends BaseEntity{
	
	private Integer quantity;
	
	@Column(name="total_price")
	@PositiveOrZero(message = "Price can't be Negative")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Orders orderId;	
	
	@OneToOne
	@JoinColumn(name="product_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Products productId;
		
	public OrderDetails() {
		super();
		System.out.println("in ctor"+getClass().getName());
	}

	public OrderDetails(Integer quantity, Double totalPrice, Orders orderId, Products productId) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.productId = productId;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public Orders getOrderId() {
		return orderId;
	}



	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}



	public Products getProductId() {
		return productId;
	}



	public void setProductId(Products productId) {
		this.productId = productId;
	}



	@Override
	public String toString() {
		return "OrderDetails [quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderId=" + orderId
				+ ", productId=" + productId + ", getId()=" + getId() + "]";
	}
	
	
	

}
