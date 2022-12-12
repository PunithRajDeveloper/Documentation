package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ty.Bookmanagement.Book_management_boot_prc.service.BookService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book, @RequestParam int id) {
		return service.saveBook(book, id);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Book>> getBook(@RequestParam int id) {
		return service.getBookById(id);
	}

	@GetMapping("/{title}")
	public ResponseEntity<ResponseStructure<Book>> getTitle(@PathVariable String title) {
		return service.getBookByTitle(title);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book, @RequestParam int id) {
		return service.updateBook(id, book);
	}

//	@DeleteMapping
//	public ResponseEntity<ResponseStructure<String>> deleteBook(@RequestParam int id)
//	{
//		return service.deleteById(id);
//	}
}
