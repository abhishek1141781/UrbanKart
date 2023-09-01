package com.app.services;

import java.util.List;

import com.app.dto.CartItemRespDTO;
import com.app.entities.Carts;
import com.app.entities.Users;

public interface CartService {

	Carts addCart(Users user);

	void emptyTheCart(Long cartId);

	Carts getMyCart(Long cartId);
	
	List<CartItemRespDTO> getMyCartItems(Long cartId);

}
