package com.app.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.customException.ElementNotFoundException;
import com.app.customException.UserAlreadyExistsException;
import com.app.dto.UsersDTO;
import com.app.dto.UsersRespDTO;
import com.app.entities.Carts;
import com.app.entities.Role;
import com.app.entities.Users;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder enc;

	@Override
	public UsersRespDTO addUserDetails(UsersDTO user) {
		Users trueUser = new Users(user.getFirstName(), user.getLastName(), user.getEmail(),
				enc.encode(user.getPassword()), user.getRole(), user.getMobileNumber());
		Optional<Users> checkUser = userRepo.findByEmail(user.getEmail());

		System.out.println("++++++++++++++++++++++++++++++++++" + checkUser);

		if (checkUser.isPresent() == true) {
			throw new UserAlreadyExistsException("User Email already exists!!!!!");
		}

		Users addeduser = userRepo.save(trueUser);
		if (addeduser.getRole() == Role.CUSTOMER) {
			Carts cart = cartService.addCart(addeduser);
			addeduser.setCart(cart);
			return mapper.map(addeduser, UsersRespDTO.class);
		} else {
			return mapper.map(addeduser, UsersRespDTO.class);
		}

	}

	@Override
	public String deleteUserDetails(Long userId) {
		cartService.emptyTheCart(userId);
		orderService.deleteOrders(userId);
		userRepo.deleteById(userId);
		return "User is Deleted";
	}

	@Override
	public Users updateUserDetails(UsersDTO user) {
		Optional<Users> oldUser = userRepo.findByEmail(user.getEmail());
		if (oldUser == null) {
			throw new ElementNotFoundException("User", "404", "Not Found");
		}
		BeanUtils.copyProperties(user, oldUser);
		return oldUser.get();
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

}
