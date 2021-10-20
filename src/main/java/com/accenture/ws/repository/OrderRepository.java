package com.accenture.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.ws.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByIsDiscounted(boolean isDiscounted);
	public Order findById(long id);
	public Order findByOrderName(String orderName);
}
