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

import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.service.UserService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);

	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@RequestParam int id) {
		return userService.updateUsetById(user, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id) {
		return userService.getUserById(id);
		
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id) {
		return userService.deleteById(id);
		
	}

}
