package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService service;

	@ApiOperation(value = "save Order", notes = "its used to save order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders orders) {
		return service.saveOrder(orders);

	}
	
	
	
	@ApiOperation(value = "update order", notes = "its used to update order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@RequestBody Orders orders,@RequestParam int id) {
		return service.saveOrder(orders);
	}
	
	
	@ApiOperation(value = "get order", notes = "its used get order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	
	@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@RequestParam int id) {
		return service.getOrderById(id);
		
	}
	@ApiOperation(value = "delete oreder", notes = "its used to delete order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	
	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteOrder(@RequestBody Orders orders,@RequestParam int id) {
		return service.deleteOrderById(orders, id);
		
	}

	

}
