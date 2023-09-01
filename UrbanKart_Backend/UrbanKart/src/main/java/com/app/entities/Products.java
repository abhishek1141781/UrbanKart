package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Valid
@Entity
@Table(name = "products")
public class Products extends BaseEntity {

	@Column(name = "name", length = 100, nullable = false)
	@NotBlank(message = "Name Should Not Be Empty")
	private String name;

	@Column(nullable = false)
	@PositiveOrZero(message = "Price should be Non-Negative")
	private Double price;

	private String description;

	@PositiveOrZero(message = "stock should be Non-Negative")
	private Integer stock;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories categoryId;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "exp_date")
	@Future(message = "Date must be in Future")
	private LocalDate expDate;

	public Products() {
		super();
		System.out.println("in ctor " + getClass().getName());
	}

	public Products(String name, Double price, String description, Integer stock, Categories categoryId,
			LocalDate expDate) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.categoryId = categoryId;
		this.expDate = expDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categories getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Categories categoryId) {
		this.categoryId = categoryId;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
}
