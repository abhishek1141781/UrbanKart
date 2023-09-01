package com.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UsersDTO;
import com.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	@PostMapping
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UsersDTO user) {
		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUserDetails(user));
	}

	@DeleteMapping("/admin/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.deleteUserDetails(userId));
	}

	@PutMapping
	public ResponseEntity<?> userUpdate(@RequestBody @Valid UsersDTO user) {

		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUserDetails(user));
	}

	@GetMapping("/admin")
	public ResponseEntity<?> getUser() {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUsers());
	}

}
