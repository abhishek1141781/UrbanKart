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
@Table(name = "cart_items")
public class CartItems extends BaseEntity{
	
	@PositiveOrZero(message = "Quantity can't be Negative")
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name = "total_price", nullable=false)
	@PositiveOrZero(message = "Price can't be Negative")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
    @JsonIgnore
	private Carts cartId;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Products productId;
	
	public CartItems() {
		super();
		System.out.println("in ctor"+getClass().getName());
	}

	public CartItems(Integer quantity, Double totalPrice, Carts cartId, Products productId) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.cartId = cartId;
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

	public Carts getCartId() {
		return cartId;
	}

	public void setCartId(Carts cartId) {
		this.cartId = cartId;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "CartItems [quantity=" + quantity + ", totalPrice=" + totalPrice + ", cartId=" + cartId + ", productId="
				+ productId + ", getId()=" + getId() + "]";
	}
	
	
	

}
