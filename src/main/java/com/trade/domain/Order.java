package com.trade.domain;

import java.time.LocalTime;
import java.util.Comparator;

public class Order implements Comparator<Order> {
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

	@Override
	public int compare(Order o1, Order o2) {
		if (o1.getSide() == OrderSide.BUY) {
			if (o1.getPrice() > o2.price && o1.time.isBefore(o2.time)) {
				return 1;
			} else {
				return -1;
			}
		} else if (o1.getSide() == OrderSide.SELL) {
			if (o1.getPrice() < o2.price && o1.time.isAfter(o2.time)) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Order [quantity=" + quantity + ", price=" + price + ", side=" + side + ", time=" + time + "]";
	}
}