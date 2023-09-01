package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Categories;
import com.app.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
	public List<Products> findByCategoryId(Categories categoryId);
	
	Long deleteByCategoryId(Categories categoryId);

}
