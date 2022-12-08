package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
