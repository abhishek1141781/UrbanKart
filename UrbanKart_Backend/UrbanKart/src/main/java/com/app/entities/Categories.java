package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Valid
@Entity
@Table(name="categories")
public class Categories extends BaseEntity{
	
	@Column(length = 50,nullable = false)
	@NotBlank(message = "categoryName Cannot be blank")
	private String categoryName;
	
	@Column(length = 1000,nullable = false)
	private String description;
	
	@Column(length = 1000,nullable = false)
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Products> productList = new HashSet<Products>();
	
	
	
	public Categories() {
		super();
	}


	public Categories(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	


	public Set<Products> getProductList() {
		return productList;
	}


	public void setProductList(Products product) {
		this.productList.add(product);
	}


	@Override
	public String toString() {
		return "Categories [category_Name=" + categoryName + ", description=" + description + ", getId()=" + getId()+ "]";
	}
	
	
	

}
