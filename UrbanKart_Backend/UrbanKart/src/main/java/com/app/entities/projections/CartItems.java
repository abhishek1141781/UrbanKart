package com.app.entities.projections;

public class CartItems {
	private Integer quantity;
	private double totalPrice;
	private int cartId;
	private int productId;

	public CartItems() {
		super();
	}

	public CartItems(Integer quantity, double totalPrice, int cartId, int productId) {
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}