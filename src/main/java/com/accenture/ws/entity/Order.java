package com.accenture.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="`order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String orderName;
	
	@Column
	private double price;
	
	@Column
	@JsonProperty
	private boolean isDiscounted;
	
	@Column
	private double isDiscountPercentage = 5.0;

	public Order() {
	}
	
	public Order(String orderName, double price, double isDiscountPercentage, boolean isDiscounted) {
		this.orderName = orderName;
		this.price = price;
		this.isDiscounted = isDiscounted;
		this.isDiscountPercentage = isDiscountPercentage;
	}

	public Order(long id, String orderName, double price, double isDiscountPercentage, boolean isDiscounted) {
		this.id = id;
		this.orderName = orderName;
		this.price = price;
		this.isDiscounted = isDiscounted;
		this.isDiscountPercentage = isDiscountPercentage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDiscounted() {
		return isDiscounted;
	}

	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

	public double getIsDiscountPercentage() {
		return isDiscountPercentage;
	}	
	

}
