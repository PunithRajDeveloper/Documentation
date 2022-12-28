package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Orders;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.OrderRepo;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class OrderControllerTest {
    @Autowired
	OrderRepo repo;

	@Test
	@Order(1)
	void testSaveOrder() {
		Orders orders=new Orders();
		orders.setName("Sona");
		orders.setPhone(66766);
		orders.setCart(null);
		orders.setAddress("JayDeva");
		//orders.setDate(null);
         repo.save(orders);
	}

	@Test
	@Order(2)
	void testUpdateOrder() {
	     Orders orders=repo.findById(1).get();
		orders.setName("Sona");
		orders.setName("Sona");
		assertEquals("Sona",orders.getName());
		//assertNotNull(repo.findById(1));
	}

	@Test
	@Order(3)
	void testGetOrderById() {
		assertNotNull(repo.findById(1));
	}

	@Test
	@Order(4)
	void testDeleteOrder() {
		repo.deleteById(1);
	}
	

}
