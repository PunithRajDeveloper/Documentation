package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;
import com.ty.Bookmanagement.Book_management_boot_prc.service.UserService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;

	@ApiOperation(value = "save user", notes = "its used to save user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Seller>> saveUser(@RequestBody Seller user) {
		return userService.saveUser(user);

	}

	@ApiOperation(value = "update user", notes = "its user to update user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Seller>> updateUser(@RequestBody Seller user, @RequestParam int id) {
		return userService.updateUsetById(user, id);
	}

	@ApiOperation(value = "used to get user", notes = "its used to get used get user data by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Seller>> getUserById(@PathVariable int id) {
		return userService.getUserById(id);

	}

	@ApiOperation(value = "user to delete user", notes = "its used delete the user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id) {
		return userService.deleteById(id);

	}

	@ApiOperation(value = "used to login user", notes = "its used to get login user by validating")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@GetMapping
	public ResponseEntity<ResponseStructure<Seller>> getUserByemail(@RequestParam String email,
			@RequestParam String password) {
		return userService.getUserbyEmail(email, password);

	}

}
