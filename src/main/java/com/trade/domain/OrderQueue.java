package com.trade.domain;

import java.util.PriorityQueue;

public class OrderQueue {
	static PriorityQueue<Order> buyQueue = new PriorityQueue<>();
	static PriorityQueue<Order> sellQueue = new PriorityQueue<>();

	public static PriorityQueue<Order> getBuyQueue() {
		return buyQueue;
	}

	public static PriorityQueue<Order> getSellQueue() {
		return sellQueue;
	}
}