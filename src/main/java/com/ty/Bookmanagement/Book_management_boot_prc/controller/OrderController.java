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

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Orders;
import com.ty.Bookmanagement.Book_management_boot_prc.service.OrderService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	OrderService service;
	
	@ApiOperation(value = "save order", notes = "its used to save order")
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
	public ResponseEntity<ResponseStructure<Orders>> saveBook(@RequestBody Orders order, @RequestParam int id) {
		return service.saveOrder(order, id);
	}
	
	@ApiOperation(value = "used to get order", notes = "its used to get order data by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Orders>> getBook(@RequestParam int id) {
		return service.getOrderById(id);
	}
	
	@ApiOperation(value = "update order", notes = "its user to update order")
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
	public ResponseEntity<ResponseStructure<Orders>> updateBook(@RequestBody Orders orders , @RequestParam int id) {
		return service.updateOrder(orders, id);
	}
	
	@ApiOperation(value = "delete order", notes = "its user to delete order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteBook(@RequestParam int id)
	{
		return service.deleteOrderById(id);
	}
}
