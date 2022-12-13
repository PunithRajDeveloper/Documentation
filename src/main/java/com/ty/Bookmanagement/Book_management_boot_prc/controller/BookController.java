package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService service;
	
	@ApiOperation(value = "save book", notes = "its used to save book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book, @RequestParam int id) {
		return service.saveBook(book, id);
	}

	@ApiOperation(value = "used to get book", notes = "its used to get book data by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Book>> getBook(@RequestParam int id) {
		return service.getBookById(id);
	}

	@GetMapping("/{title}")
	public ResponseEntity<ResponseStructure<Book>> getTitle(@PathVariable String title) {
		return service.getBookByTitle(title);
	}

	@ApiOperation(value = "update book", notes = "its user to update book")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 202, message = "accepted"),
			@ApiResponse(code = 203, message = "non-authoritataive information"),
			@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
			@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
			@ApiResponse(code = 408, message = "request timeout"),
			@ApiResponse(code = 500, message = "imternal server error"), })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book, @RequestParam int id) {
		return service.updateBook(id, book);
	}

//	@DeleteMapping
//	public ResponseEntity<ResponseStructure<String>> deleteBook(@RequestParam int id)
//	{
//		return service.deleteById(id);
//	}
}