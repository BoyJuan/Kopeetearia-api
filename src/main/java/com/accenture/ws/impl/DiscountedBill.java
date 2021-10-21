package com.accenture.ws.impl;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.OrderBill;

public class DiscountedBill extends OrderBill{

	public DiscountedBill(CafeClerk clerk) {
		super(clerk);
	}

	@Override
	public double getTotalBill(){
		double totalBill = 0;
		double discount = 0.05;
		
		for(int i=0; i<getOrderList().size(); i++) {
			if(getOrderList().get(i).isDiscounted()) {
				totalBill += getOrderList().get(i).getPrice()-
						((getOrderList().get(i).getPrice())*discount);
			}else {
				totalBill += getOrderList().get(i).getPrice();
			}
		}
		return totalBill;
	}
}
