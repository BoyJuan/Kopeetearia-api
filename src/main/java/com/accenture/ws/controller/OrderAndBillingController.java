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
	private final String url = "http://localhost:4201";

//	private OrderAndBillingController(CafeClerk clerk) {
//		this.clerk = clerk;
//	}

	@GetMapping(value = "/orders")
	@CrossOrigin(origins = url)
	public List<Order> getOrderList(){
		return orderRepo.findAll();
	}
	
	@PostMapping(value = "/add")
	@CrossOrigin(origins = url)
	public void addOrder(@RequestBody Order order) {
		orderRepo.save(order);
	}
	
	@PutMapping(value = "/update")
	@CrossOrigin(origins = url)
	public void updateOrder(@RequestBody Order order) {
		orderRepo.save(order);
	}
	
	@PostMapping(value = "/delete")
	@CrossOrigin(origins = url)
	public void deleteOrder(@RequestBody Order order) {
		orderRepo.delete(order);
	}
	
	@GetMapping(value = "/total-regular-bill")
	@CrossOrigin(origins = url)
	public OrderBill getTotalRegularBill() {
		
		OrderBill regularBill = new RegularBill(clerk);
		List<Order> regularOrders =  orderRepo.findAll();
		
		regularBill.setOrderList(regularOrders);
		new RegularBill(clerk).getTotalBill();
		
		return regularBill;
	}
	
	@GetMapping(value = "/total-discounted-bill")
	@CrossOrigin(origins = url)
	public OrderBill getTotalDiscountedBill() {
		
		OrderBill discountedBill = new DiscountedBill(clerk);
		List<Order> discountedOrders =  orderRepo.findAll();
		
		discountedBill.setOrderList(discountedOrders);
		new DiscountedBill(clerk).getTotalBill();
		
		return discountedBill;
	}

}
