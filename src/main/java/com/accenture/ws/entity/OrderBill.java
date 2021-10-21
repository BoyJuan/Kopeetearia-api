package com.accenture.ws.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class OrderBill {
	

	private List<Order> orderList = new ArrayList<>();
	private CafeClerk clerk;
	
	public OrderBill(CafeClerk clerk) {
		this.clerk = clerk;
	}

	protected CafeClerk getClerk() {
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
