package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.CartRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

class CartControllerTest {
	@Autowired
	CartRepo cartrepo;

	@Test
	@Order(1)
	void testsaveCart() {
		Cart cart = new Cart();
		cart.setId(1);
		cart.setProducts(null);
		cart.setTotalcost(1180);
		cartrepo.save(cart);
	}

	@Test
	@Order(2)
	void testupdateCart() {
		Cart cart = cartrepo.findById(1).get();
		cart.setTotalcost(2000);
		cartrepo.save(cart);
		assertEquals(2000, cart.getTotalcost());

	}

	@Test
	@Order(3)
	void testgetCart() {
		assertNotNull(cartrepo.findById(1));
	}

	@Test
	@Order(4)
	void testdeleteCart() {

		cartrepo.deleteById(1);
	}

}
