package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.SellerRepo;

@SpringBootTest
class UserControllerTest {

	@Autowired
	SellerRepo repo;
	@Test
	void testSaveUser() {
		Seller u=new Seller();
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
		Seller u=repo.findById(1).get();
		
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
