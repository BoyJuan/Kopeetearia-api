package com.accenture.ws.entity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.Order;

public abstract class OrderBill {
	
	private static final Logger log = LoggerFactory.getLogger(
			OrderBill.class); 

	private List<Order> orderList = new ArrayList<Order>();
	private CafeClerk clerk;
	
	public OrderBill(CafeClerk clerk) {
		this.clerk = clerk;
	}

	public CafeClerk getClerk() {
		return clerk;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public abstract double getTotalBill();
	
	
}
