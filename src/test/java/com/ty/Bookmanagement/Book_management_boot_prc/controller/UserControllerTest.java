package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.UserRepo;

@SpringBootTest
class UserControllerTest {

	@Autowired
	UserRepo repo;
	@Test
	void testSaveUser() {
		User u=new User();
		u.setId(1);
		u.setAddress("Banglore");
		u.setBooks(null);
		u.setEmail("@mail");
		u.setGender("male");
		u.setName("s");
		u.setPassword("123");
		u.setPhonNum(981981);
		repo.save(u);
		assertNotNull(repo.getById(7));
	}

	@Test
	void testUpdateUser() {
		User u=repo.findById(1).get();
		
		u.setAddress("hydrabad");
		u.setBooks(null);
		u.setEmail("@yahoo");
		repo.save(u);
assertNotNull(repo.findById(7));
		
	}

	@Test
	void testGetUserById() {
		assertNotNull(repo.getById(1));
	}
	
	@Test
	void testGetUserByemail() {
		assertNotNull(repo.getByEmail("@yahoo"));
	}

	@Test
	void testDeleteUser() {
		
		repo.deleteById(1);
		
	}

}
