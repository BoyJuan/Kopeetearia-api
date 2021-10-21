package com.accenture.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.impl.DiscountedBill;
import com.accenture.ws.impl.RegularBill;
import com.accenture.ws.repository.OrderRepository;

@RestController
public class OrderAndBillingController {
	
	@Autowired
	private OrderRepository orderRepo;
	
	private CafeClerk clerk;
	private static final String CONST_URL = "http://localhost:4201";

	@GetMapping(value = "/orders")
	@CrossOrigin(origins = CONST_URL)
	public List<Order> getOrderList(){
		return orderRepo.findAll();
	}
	
	@PostMapping(value = "/add")
	@CrossOrigin(origins = CONST_URL)
	public void addOrder(@RequestBody Order order) {
		orderRepo.save(order);
	}
	
	@PutMapping(value = "/update")
	@CrossOrigin(origins = CONST_URL)
	public void updateOrder(@RequestBody Order order) {
		orderRepo.save(order);
	}
	
	@PostMapping(value = "/delete")
	@CrossOrigin(origins = CONST_URL)
	public void deleteOrder(@RequestBody Order order) {
		orderRepo.delete(order);
	}
	
	@GetMapping(value = "/total-regular-bill")
	@CrossOrigin(origins = CONST_URL)
	public OrderBill getTotalRegularBill() {
		
		OrderBill regularBill = new RegularBill(clerk);
		List<Order> regularOrders =  orderRepo.findAll();
		
		regularBill.setOrderList(regularOrders);
		new RegularBill(clerk).getTotalBill();
		
		return regularBill;
	}
	
	@GetMapping(value = "/total-discounted-bill")
	@CrossOrigin(origins = CONST_URL)
	public OrderBill getTotalDiscountedBill() {
		
		OrderBill discountedBill = new DiscountedBill(clerk);
		List<Order> discountedOrders =  orderRepo.findAll();
		
		discountedBill.setOrderList(discountedOrders);
		new DiscountedBill(clerk).getTotalBill();
		
		return discountedBill;
	}

}
