package com.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.ElementNotFoundException;
import com.app.dto.CartItemRespDTO;
import com.app.entities.Carts;
import com.app.entities.Products;
import com.app.entities.Users;
import com.app.repository.CartRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemsService cartItemsService;

	@Override
	public Carts addCart(Users user) {
		Carts cart = new Carts();
		cart.setCreated(LocalDate.now());
		cart.setUpdated(LocalDate.now());
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	@Override
	public void emptyTheCart(Long userId) {
		Carts cart = repository.findById(userId)
				.orElseThrow(() -> new ElementNotFoundException("User", "404", "Not Found")).getCart();
		cart.emptyCartItems();
		cart.setTotalItems(0);
		cart.setTotalPrice(0);
		cart.setUpdated(LocalDate.now());

		cartItemsService.DeleteCartItemsFromCart(cart);

	}

	@Override
	public Carts getMyCart(Long userId) {

		Carts cart = repository.findById(userId)
				.orElseThrow(() -> new ElementNotFoundException("User", "404", "Not Found")).getCart();
		List<CartItemRespDTO> tempList = new ArrayList<CartItemRespDTO>();
		if (cart.getTotalItems() == 0) {
			throw new ElementNotFoundException("Cart ", "404", " is Empty");
		}

		cart.getCartItems().forEach(x -> {
			tempList.add(new CartItemRespDTO(x.getQuantity(), x.getTotalPrice(), x.getCartId().getId(),
					x.getProductId().getId(), x.getProductId().getName()));
		});

		return cart;
	}

	@Override
	public List<CartItemRespDTO> getMyCartItems(Long userId) {

		Carts cart = repository.findById(userId)
				.orElseThrow(() -> new ElementNotFoundException("User", "404", "Not Found")).getCart();
		List<CartItemRespDTO> tempList = new ArrayList<CartItemRespDTO>();
		if (cart.getTotalItems() == 0) {
			throw new ElementNotFoundException("Cart ", "404", " is Empty");
		}

		cart.getCartItems().forEach(x -> {
			tempList.add(new CartItemRespDTO(x.getQuantity(), x.getTotalPrice(), x.getCartId().getId(),
					x.getProductId().getId(), x.getProductId().getName()));
		});

		return tempList;
	}

}
