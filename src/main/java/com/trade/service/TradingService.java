package com.trade.service;

import com.trade.domain.Order;

public interface TradingService {
	void placeOrder(Order order);
}