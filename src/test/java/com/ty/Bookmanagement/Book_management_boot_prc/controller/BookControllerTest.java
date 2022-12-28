package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.BookRepositery;

@SpringBootTest
class BookControllerTest {

	@Autowired
	BookRepositery repo; 
	
	@Test
	void testSaveBook() {
		Book book=new Book();
		book.setTitle("Ramayana");
		book.setAuther("Valmiki");
		book.setCategory("relegious");
		book.setPublications("Nlanda publications");
		book.setPrice(114);
		repo.save(book);
		assertNotNull(repo.findById(12));
		
	}

	@Test
	void testGetBook() {
		Book book=repo.findById(12).get();
		book.setAuther("Suhas");
		assertNotNull(repo.findById(12));
	}

	@Test
	void testGetTitle() {
		assertNotNull(repo.getByTitle("JAVA"));
	}

	@Test
	void testUpdateBook() {
		Book book=repo.findById(12).get();
		book.setAuther("Suhas");
		assertNotNull(repo.findById(12));
	}
	
	@Test
	void testDelete() {
		repo.deleteById(12);
	}

}
