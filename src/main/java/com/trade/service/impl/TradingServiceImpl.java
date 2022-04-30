package com.trade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.trade.domain.Order;
import com.trade.domain.OrderQueue;
import com.trade.domain.OrderSide;
import com.trade.service.TradingService;

@Component
public class TradingServiceImpl implements TradingService {

	private OrderQueue<Order> orderQueue = new OrderQueue<>();

	@Override
	public void placeOrder(Order order) {
		if (OrderSide.BUY == order.getSide()) {
			orderQueue.getBuyQueue().add(order);
		} else {
			orderQueue.getSellQueue().add(order);
		}
	}

	@Override
	public Map<String, List<Order>> getOrderBook(int limit) {
		Map<String, List<Order>> orderBook = new HashMap<>();
		List<Order> buyList = new ArrayList<>();
		List<Order> sellList = new ArrayList<>();
		int buyQueueLimit = limit > orderQueue.getBuyQueue().size() ? orderQueue.getBuyQueue().size() : limit;
		int sellQueueLimit = limit > orderQueue.getSellQueue().size() ? orderQueue.getSellQueue().size() : limit;
		for (int i = 0; i < buyQueueLimit; i++) {
			Order buyOrder = orderQueue.getBuyQueue().peek();
			if (buyOrder != null) {
				buyList.add(buyOrder);
			}
		}
		for (int i = 0; i < sellQueueLimit; i++) {
			Order sellOrder = orderQueue.getSellQueue().peek();
			if (sellOrder != null) {
				sellList.add(sellOrder);
			}
		}
		orderBook.put("buyList", buyList);
		orderBook.put("sellList", sellList);
		return orderBook;
	}
}