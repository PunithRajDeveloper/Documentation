package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Orders;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.service.OrderService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders orders) {
		return service.saveOrder(orders);

	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@RequestBody Orders orders,@RequestParam int id) {
		return service.saveOrder(orders);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@RequestParam int id) {
		return service.getOrderById(id);
		
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteOrder(@RequestBody Orders orders,@RequestParam int id) {
		return service.deleteOrderById(orders, id);
		
	}

	

}
