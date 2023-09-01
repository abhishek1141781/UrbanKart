package com.app.entities.projections;

import java.time.LocalDate;

public class ProductsProjection {
	private Long Id;
	private String name;
	private Double price;
	private String description;
	private Integer stock;
	private String categoryName;
	private String imagePath;
	private LocalDate expDate;

	public ProductsProjection() {
		super();
		System.out.println("in ctor " + getClass().getName());
	}

	public ProductsProjection(Long Id, String name, Double price, String description, Integer stock,
			String categoryName, String imagePath, LocalDate expDate) {
		super();
		this.Id = Id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.categoryName = categoryName;
		this.imagePath = imagePath;
		this.expDate = expDate;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

}
