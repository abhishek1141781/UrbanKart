package com.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.ElementNotFoundException;
import com.app.customException.OutOfStockException;
import com.app.dto.DeliveryAddressDTO;
import com.app.dto.OrdersRespDTO;
import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.DeliveryAddress;
import com.app.entities.OrderDetails;
import com.app.entities.Orders;
import com.app.entities.Products;
import com.app.entities.Status;
import com.app.entities.Users;
import com.app.repository.AddressRepository;
import com.app.repository.OrderDetailsRepository;
import com.app.repository.OrderRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderDetailsRepository detailsRepository;

	@Autowired
	private CartService cartService;

	@Override
	public OrdersRespDTO placeOrder(Long userId,DeliveryAddressDTO address) {
		DeliveryAddress trueAddress=new DeliveryAddress(address.getAddressLine1(),address.getAddressLine2(),address.getCity(),address.getState(),address.getZipCode());
		DeliveryAddress addedAddress=addressRepository.save(trueAddress);
		Users user=userRepository.findById(userId).orElseThrow(()->new ElementNotFoundException("User", "404", "Not Found1231321231231"));
		Orders order=new Orders( LocalDate.now(),LocalDate.of(2024, 12, 12), Status.PLACED, 0, 40 , user, addedAddress);
		Orders neworder=orderRepository.save(order);
		Carts cart=user.getCart();
		Set<CartItems> cartItems=user.getCart().getCartItems();
		cartItems.forEach(x->{
			OrderDetails oDetails = new OrderDetails(x.getQuantity() , x.getTotalPrice(),neworder,x.getProductId());
			Products product=x.getProductId();
			if(product.getStock()==0 || x.getQuantity()>product.getStock()) {
				throw new OutOfStockException("Product "+product.getName(), "403", "Out Of Stock");
			}
			product.setStock(product.getStock()-x.getQuantity());//Product Stock is Updated (Decreased)
			neworder.setOrderDetails(detailsRepository.save(oDetails));

		});
		neworder.setTotalPrice(cart.getTotalPrice()+neworder.getShippingPrice());
		neworder.setStatus(Status.PLACED);
		cartService.emptyTheCart(user.getId());
		return  new OrdersRespDTO(neworder.getOrderDate(), neworder.getDeliveryDate(), neworder.getStatus(), neworder.getTotalPrice(), neworder.getShippingPrice(), user.getId(), addedAddress.getId());
	}

	@Override
	public List<Orders> getAllOrders() {

		List<Orders> list=orderRepository.findAll();
		list.forEach(x->{
			x.getOrderDetails().forEach(y->{y.getQuantity();});
			x.getUserOrdered().getCart().getCartItems().forEach(z->z.getQuantity());
			x.getAddress().getAdressLine1();
		});
		return list;
	}

	@Override
	public List<Orders> getMyOrders(Long Id) {
		Optional<Users> user=userRepository.findById(Id);

		List<Orders> list=orderRepository.findByUserOrdered(user.get());
		list.forEach(x->{
			x.getOrderDetails().forEach(y->{y.getQuantity();});
			x.getUserOrdered().getCart().getCartItems().forEach(z->z.getQuantity());
			x.getAddress().getAdressLine1();
		});

		return list;
	}



	@Override
	public void deleteOrder(Long orderId) {		
		orderRepository.deleteById(orderId);	
	}

	@Override
	public void deleteOrders(Long userId) {
		Users user=userRepository.findById(userId).orElseThrow(()->new ElementNotFoundException("User", "404", "Not Found"));
		orderRepository.deleteByuserOrdered(user);

	}

	@Override
	public void cancelOrder(Long orderId) {
		Orders order=orderRepository.findById(orderId).orElseThrow(()->new ElementNotFoundException("Order", "404", "Not Found"));
		if(order.getStatus()!=Status.DELIVERED || order.getStatus()!=Status.CANCELED) {
			order.getOrderDetails().forEach(x->{
				x.getProductId().setStock(x.getProductId().getStock()+x.getQuantity());//Product Stock is Updated (Increased)
			});
			order.setStatus(Status.CANCELED);
		}
	}

	@Override
	public void updateOrderStatus(Long orderId,String status,LocalDate deliveryDate) {
		Orders order=orderRepository.findById(orderId).orElseThrow(()->new ElementNotFoundException("Order", "404", "Not Found"));
		order.setStatus(Status.valueOf(status));
		order.setDeliveryDate(deliveryDate);
	}
}
