package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.ProductRepo;

@SpringBootTest
class ProductControllerTest {

	@Autowired
	ProductRepo repo;

	@Test
	void testSaveProduct() {
		Product product = new Product();
		product.setQuantity(12);
		product.setBooks(null);

		repo.save(product);
		assertNotNull(repo.findById(1));

	}

	@Test
	void testUpdateProduct() {
		Product product=repo.findById(4).get();
		product.setQuantity(20);
		repo.save(product);
		assertEquals(20,repo.findById(4).get().getQuantity() );
		
	}

	@Test
	void testGetProductById() {
		assertNotNull(repo.findById(4).get());
		
	}

	@Test
	void testDeleteProductById() {
		repo.deleteById(5);
		
	}

}
