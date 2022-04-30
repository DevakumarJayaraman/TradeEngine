package com.trade.service.impl;

import org.springframework.stereotype.Component;

import com.trade.domain.Order;
import com.trade.domain.OrderQueue;
import com.trade.domain.OrderSide;
import com.trade.service.TradingService;

@Component
public class TradingServiceImpl implements TradingService {
	@Override
	public void placeOrder(Order order) {
		if (OrderSide.BUY == order.getSide()) {
			OrderQueue.getBuyQueue().add(order);
		} else {
			OrderQueue.getSellQueue().add(order);
		}
	}
}