package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartItemDTO;
import com.app.services.CartItemsService;

@RestController
@RequestMapping("/cartitem")
@ResponseBody
public class CartItemController {
	
	@Autowired
	private CartItemsService cartItemsService;
	
	
	@PostMapping
	public ResponseEntity<?> addToCart(@RequestBody CartItemDTO cartItem) {

		return new ResponseEntity<>(cartItemsService.addToCart(cartItem), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{cartItemId}")
	public ResponseEntity<String> deleteItem(@PathVariable Long cartItemId) {
		cartItemsService.deleteItem(cartItemId);
		return new ResponseEntity<String>("CartItem is Deleted", HttpStatus.CREATED);
	}
	
	@GetMapping("/{cartItemId}")
	public ResponseEntity<String> updateItem(@PathVariable Long cartItemId) {
		cartItemsService.updateItem(cartItemId);
		return new ResponseEntity<String>("CartItem is Updated", HttpStatus.CREATED);
	}	
}
