package com.trade.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.domain.Order;
import com.trade.service.TradingService;

@RestController
@RequestMapping("/trade")
public class TradingEndpoint {

	@Autowired
	private TradingService tradeService;

	@GetMapping(path = "/getOrderBook/{limit}", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> getOrderBook(@PathVariable("limit") int limit) {
		Map<String, List<Order>> orderbook = tradeService.getOrderBook(limit);
		List<Order> buyList = orderbook.get("buyList");
		List<Order> sellList = orderbook.get("sellList");

		StringBuilder htmlBuilder = new StringBuilder();

		htmlBuilder.append("<table  BORDER=2 CELLSPACING=0 CELLPADDING=5>");
		htmlBuilder.append("<tr><th valign='left' colspan=3>BUY</th><th valign='left' colspan=3>SELL</th></tr>");
		htmlBuilder.append("<tr><td>Qty</td><td>Price</td><td>Time</td><td>Qty</td><td>Price</td><td>Time</td></tr>");

		for (int i = 0; i <= limit; i++) {
			htmlBuilder.append("<tr>");
			if (buyList.size() > i) {
				htmlBuilder.append("<td>" + buyList.get(i).getQuantity() + "</td>");
				htmlBuilder.append("<td>" + buyList.get(i).getPrice() + "</td>");
				htmlBuilder.append("<td>" + buyList.get(i).getTime() + "</td>");
			}
			if (sellList.size() > i) {
				htmlBuilder.append("<td>" + sellList.get(i).getQuantity() + "</td>");
				htmlBuilder.append("<td>" + sellList.get(i).getPrice() + "</td>");
				htmlBuilder.append("<td>" + sellList.get(i).getTime() + "</td>");
			}
			htmlBuilder.append("</tr>");
		}
		htmlBuilder.append("</table");
		return ResponseEntity.ok(htmlBuilder.toString());
	}
}