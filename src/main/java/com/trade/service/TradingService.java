package com.trade.service;

import java.util.List;
import java.util.Map;

import com.trade.domain.Order;

public interface TradingService {
	void placeOrder(Order order);

	Map<String, List<Order>> getOrderBook(int limit);
}