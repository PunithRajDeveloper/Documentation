package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.BookDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dao.UserDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchCatagoryFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class BookService {
	private static final Logger logger = Logger.getLogger(BookService.class);

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<Book>> saveBook(List<Book> book, String email, String password) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		User u1 = dao.getByEmail(email);
		if (u1 != null && u1.getPassword().equals(password)) {

			List<Book> list = new ArrayList<Book>(book);
			List<Book> l2 = u1.getBooks();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Saved");
			for(Book b : list )
			{
				l2.add(b);
				responseStructure.setData(bookDao.saveBook(b));	
			}
			u1.setBooks(l2);
			dao.updateUser(u1);
			logger.info("BOOK SAVED");
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.CREATED);

		}
		logger.error("BOOK FAILED TO SAVE");
		throw new NoSuchIdFoundException();

	}

	public ResponseEntity<ResponseStructure<Book>> getBookById(int id) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		Optional<Book> book = bookDao.getBookbyId(id);
		if (book.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(bookDao.getBookbyId(id).get());
			logger.info("BOOK FOUND");
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		}
		logger.error("BOOK ID NOT FOUND");
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<Book>> getBookByCatagory(String category) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		Book book = bookDao.getBookbyCategory(category);
		if (book != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(bookDao.getBookbyCategory(category));
			logger.info("BOOK CATEGORY FOUND");
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		}
		logger.error("BOOK CATEGORY NOT FOUND");
		throw new NoSuchCatagoryFoundException();
	}

	public ResponseEntity<ResponseStructure<Book>> getBookByTitle(String title) {
		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(bookDao.getBookByTitle(title));
		logger.info("BOOK TITLE FOUND");
		return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Book>> updateBook(int id, Book book) {

		ResponseEntity<ResponseStructure<Book>> entity;
		ResponseStructure<Book> responseStructure = new ResponseStructure();
		Book b2 = bookDao.getBookbyId(id).get();
		if (b2 != null) {
			book.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(bookDao.updateBookbyId(book));
			logger.info("BOOK UPDATED");
			return entity = new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);
		}
		logger.error("BOOK FAILED TO UPDATE");
		throw new UnableToUpdateException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id, String email, String password) {

		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure();
		User u1 = dao.getByEmail(email);
		if (u1 != null && u1.getPassword().equals(password)) {
			List<Book> b1 = u1.getBooks();
			for (int i = 0; i < b1.size(); i++) {
				if (b1.get(i).getId() == id) {
					b1.remove(i);
					responseStructure.setStatus(HttpStatus.OK.value());
					responseStructure.setMessage("Deleted");
					responseStructure.setData(bookDao.deleteBookbyId(id));
					logger.info("BOOK DELETED");
					return entity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
				}

			}
		}

		logger.error("Invalid Credentials");
		throw new NoSuchIdFoundException("Invalid Credetials");
	}

}
