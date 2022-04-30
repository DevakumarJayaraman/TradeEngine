package com.trade.service;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.trade.domain.Order;
import com.trade.domain.OrderSide;
import com.trade.service.impl.TradingServiceImpl;

@ContextConfiguration(classes = TradingServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class TradingServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(TradingService.class);

	@Autowired
	private TradingService tradingService;

	@Test
	public void testPlaceOrder() {
		LOG.info("testPlaceOrder");
		tradingService.placeOrder(new Order(1, 100, 10, OrderSide.BUY, LocalTime.now()));
	}
}