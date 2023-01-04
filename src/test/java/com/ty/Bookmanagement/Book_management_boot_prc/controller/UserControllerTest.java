package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.SellerRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserControllerTest {

	@Autowired
	SellerRepo repo;

	@Test
	@Order(1)
	void testSaveUser() {

		Seller u = new Seller();

		u.setId(1);
		u.setAddress("Banglore");
		u.setBooks(null);
		u.setEmail("@gmail");
		u.setGender("male");
		u.setName("s");
		u.setPassword("123");
		u.setPhonNum(981981);
		repo.save(u);
		assertNotNull(repo.findById(1));
	}

	@Test
	@Order(2)
	void testUpdateUser() {

		Seller u = repo.findById(1).get();

		u.setAddress("Haveri");
		u.setBooks(null);
		u.setEmail("@yahoo");
		repo.save(u);
		assertNotNull(repo.findById(1));

	}

	@Test
	@Order(3)
	void testGetUserById() {
		assertNotNull(repo.findById(1));
	}

	@Test
	@Order(4)
	void testGetUserByemail() {
		Seller u1 = repo.getByEmail("@yahoo");
		assertEquals(u1.getPassword(), "123");
	}

	@Test
	@Order(5)
	void testDeleteUser() {

		repo.deleteById(1);

	}

}
