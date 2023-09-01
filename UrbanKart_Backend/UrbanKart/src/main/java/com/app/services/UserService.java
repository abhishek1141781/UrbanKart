package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.UsersDTO;
import com.app.dto.UsersRespDTO;
import com.app.entities.Users;

public interface UserService {
	UsersRespDTO addUserDetails(UsersDTO user);

	String deleteUserDetails(Long userId);

	Users updateUserDetails(@Valid UsersDTO user);

	List<Users> getAllUsers();
	

}
