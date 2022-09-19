package com.icecool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icecool.exception.InvalidOrderException;
import com.icecool.exception.ResourceNotFoundException;
import com.icecool.model.Order;
import com.icecool.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	@PostMapping("")
	public ResponseEntity<?> orderPrice(@RequestBody Order order) throws ResourceNotFoundException, InvalidOrderException{
		
		 return ResponseEntity.ok(orderService.getTotalPrice(order));
	}
}
