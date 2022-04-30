package com.trade.client;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trade.domain.Order;
import com.trade.domain.OrderSide;
import com.trade.service.TradingService;

@Component
public class TradeClientRunner {

	private static final Logger LOG = LoggerFactory.getLogger(TradingService.class);

	@Autowired
	private TradingService tradingService;

	@PostConstruct
	public void schedule() {
		scheduleTradingClient();
	}

	public void scheduleTradingClient() {
		AtomicInteger orderId = new AtomicInteger(0);
		final ScheduledExecutorService buyers = Executors.newScheduledThreadPool(10);
		buyers.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Order order = new Order(orderId.addAndGet(1), getRandomQuantity(), getRandomPrice(), OrderSide.BUY,
						LocalTime.now());
				LOG.info("Adding buy order : {}", order);
				tradingService.placeOrder(order);
			}
		}, 10, 1, TimeUnit.SECONDS);

		final ScheduledExecutorService sellers = Executors.newScheduledThreadPool(10);
		sellers.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Order order = new Order(orderId.addAndGet(1), getRandomQuantity(), getRandomPrice(), OrderSide.SELL,
						LocalTime.now());
				LOG.info("Adding sell order : {}", order);
				tradingService.placeOrder(order);
			}
		}, 10, 1, TimeUnit.SECONDS);
	}

	private double getRandomPrice() {
		DecimalFormat formatter = new DecimalFormat("#0.00"); // edited here.
		double randomValue = 30 + Math.random() * (35 - 30);
		double tempRes = Math.floor(randomValue * 10);
		return Double.valueOf(formatter.format(tempRes / 10));
	}

	private int getRandomQuantity() {
		return (int) (Math.random() * (100 - 50)) + 50;
	}
}