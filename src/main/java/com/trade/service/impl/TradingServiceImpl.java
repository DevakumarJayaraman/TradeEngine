package com.trade.service.impl;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.trade.domain.Order;
import com.trade.service.TradingService;

@Component
public class TradingServiceImpl implements TradingService {

	LinkedList<Order> buyList = new LinkedList<>();

	@Override
	public void placeOrder(Order order) {
		buyList.push(e);
	}
}