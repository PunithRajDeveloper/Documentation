package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.BookDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchCatagoryFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.BookRepositery;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;

	ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(bookDao.saveBook(book));
		return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.CREATED);
	}

	ResponseEntity<ResponseStructure<Book>> getBookById(int id) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		Optional<Book> book = bookDao.getBookbyId(id);
		if (book.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(bookDao.getBookbyId(id).get());
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		}

		throw new NoSuchIdFoundException();
	}

	ResponseEntity<ResponseStructure<Book>> getBookByCatagory(String category) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		Book book = bookDao.getBookbyCategory(category);
		if (book != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(bookDao.getBookbyCategory(category));
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchCatagoryFoundException();
	}

	ResponseEntity<ResponseStructure<Book>> getBookByTitle(String title) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(bookDao.getBookByTitle(title));
		return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
	}

	ResponseEntity<ResponseStructure<Book>> updateBook(int id, Book book) {

		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		Book b2 = bookDao.getBookbyId(id).get();
		if (b2 != null) {
			b2.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(bookDao.updateBookbyId(book));
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		}
		throw new UnableToUpdateException();
	}
	
	ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		
	
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure();
		Book b2 = bookDao.getBookbyId(id).get();
		b2.setId(0);
		bookDao.updateBookbyId(b2);
		if (b2 != null) {
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(bookDao.deleteBookbyId(id));
			return entity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException();
	}

}
