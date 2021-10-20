package com.accenture.ws.impl;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.OrderBill;

public class RegularBill extends OrderBill{

	public RegularBill(CafeClerk clerk) {
		super(clerk);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getTotalBill(){
		double totalBill = 0;
		
		for(int i=0; i<getOrderList().size(); i++) {
			totalBill += getOrderList().get(i).getPrice();
		}
		
		return totalBill;
	}
}
