package com.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.ElementNotFoundException;
import com.app.customException.OutOfStockException;
import com.app.dto.CartItemDTO;
import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.Products;
import com.app.repository.CartItemsRepository;
import com.app.repository.CartRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartItemsServiceImple implements CartItemsService {

	@Autowired
	private CartItemsRepository cartItemsRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CartItems addToCart(CartItemDTO cartItem) {

		Products product = productRepository.findById(cartItem.getProductId())
				.orElseThrow(() -> new ElementNotFoundException("Product", "404", "Not Found"));
		Carts cart = repository.findById(cartItem.getUserId())
				.orElseThrow(() -> new ElementNotFoundException("Cart", "404", "Not Found")).getCart();

		if (product.getStock() == 0 || cartItem.getQuantity() > product.getStock()) {
			throw new OutOfStockException(product.getName(), "403", "Out Of Stock");
		}

		CartItems sameItem = cartItemsRepository.findByProductIdAndCartId(product, cart);
		Double cartItemPrice = product.getPrice() * cartItem.getQuantity();
		if (sameItem != null) {
			sameItem.setQuantity(sameItem.getQuantity() + cartItem.getQuantity());
			sameItem.setTotalPrice(sameItem.getTotalPrice() + cartItemPrice);

			cart.setTotalPrice(cart.getTotalPrice() + cartItemPrice);
			cart.setTotalItems(cart.getTotalItems() + cartItem.getQuantity());
			return sameItem;

		} else {
			CartItems newCartItem = new CartItems(cartItem.getQuantity(), cartItemPrice, cart, product);
			cart.setTotalPrice(cart.getTotalPrice() + cartItemPrice);
			cart.setCartItems(newCartItem);// Newly Added
			cart.setTotalItems(cart.getTotalItems() + cartItem.getQuantity());
			return cartItemsRepository.save(newCartItem);
		}
	}

	@Override
	public Set<CartItems> getCartItems(Long userId) {

		Carts cart = repository.findById(userId)
				.orElseThrow(() -> new ElementNotFoundException("Cart", "404", "Not Found")).getCart();
		Set<CartItems> tempList = cart.getCartItems();
		if (tempList.size() == 0) {
			throw new ElementNotFoundException("CartItems", "404", "List is Empty");

		}
		return tempList;
	}

	@Override
	public void DeleteCartItemsFromCart(Carts cartId) {
		cartItemsRepository.deleteByCartId(cartId);
	}

	@Override // used in product service impl while deleting a single product
	public void deleteByProductId(Products product) {
		List<CartItems> cartItems = cartItemsRepository.findByProductId(product);
		if (cartItems.size() == 0) {
			throw new ElementNotFoundException(" CartItems", "404", "List is Empty");
		}
		cartItems.forEach(x -> {
			Carts cart = x.getCartId();
			Set<CartItems> items = cart.getCartItems();
			cart.setTotalItems(cart.getTotalItems() - 1);
			cart.setTotalPrice(cart.getTotalItems() - x.getTotalPrice());
			cart.setUpdated(LocalDate.now());
			items.remove(x);

		});
		cartItemsRepository.deleteByProductId(product);

	}

	@Override // used for deleting cart item from cart
	public void deleteItem(Long cartItemId) {
		CartItems item = cartItemsRepository.findById(cartItemId)
				.orElseThrow(() -> new ElementNotFoundException("Item", "404", "Not Found"));
		Carts cart = item.getCartId();
		cart.getCartItems().remove(item);

		cart.setTotalItems(cart.getTotalItems() - item.getQuantity());
		cart.setTotalPrice(cart.getTotalPrice() - item.getTotalPrice());
		cart.setUpdated(LocalDate.now());
		cartItemsRepository.deleteById(cartItemId);

	}

	@Override
	public void updateItem(Long cartItemId) {
		CartItems item = cartItemsRepository.findById(cartItemId)
				.orElseThrow(() -> new ElementNotFoundException("Item", "404", "Not Found"));
		item.setQuantity(item.getQuantity() - 1);
		item.getCartId().setTotalItems(item.getCartId().getTotalItems() - 1);

	}

}
