package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.Products;

public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
		
	Long deleteByCartId(Carts cartId);
	
	Long deleteByProductId(Products product);

	List<CartItems> findByProductId(Products product);
	
	CartItems findByProductIdAndCartId(Products product, Carts cart);
	

}
