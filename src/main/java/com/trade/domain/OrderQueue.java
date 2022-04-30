package com.trade.domain;

import java.util.PriorityQueue;

public class OrderQueue<T> {
	PriorityQueue<T> buyQueue = new PriorityQueue<>();
	PriorityQueue<T> sellQueue = new PriorityQueue<>();

	public PriorityQueue<T> getBuyQueue() {
		return buyQueue;
	}

	public PriorityQueue<T> getSellQueue() {
		return sellQueue;
	}
}