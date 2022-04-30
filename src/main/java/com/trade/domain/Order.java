package com.trade.domain;

import java.time.LocalTime;

public class Order {
	private int id;
	private int quantity;
	private double price;
	private OrderSide side;
	private LocalTime time;

	public Order(int id, int quantity, double price, OrderSide side, LocalTime time) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.side = side;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public OrderSide getSide() {
		return side;
	}

	public LocalTime getTime() {
		return time;
	}
}