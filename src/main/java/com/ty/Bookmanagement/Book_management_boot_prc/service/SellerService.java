package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.BookDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dao.SellerDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToDeleteException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class SellerService {

	private static final Logger logger = Logger.getLogger(SellerService.class);

	@Autowired
	SellerDao userDao;

	@Autowired
	BookDao bookDao;

	public ResponseEntity<ResponseStructure<Seller>> saveUser(Seller user) {
		ResponseStructure<Seller> responseStructure = new ResponseStructure<Seller>();

		Seller u1 = userDao.getByEmail(user.getEmail());
		if (u1 == null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("SAVED");
			responseStructure.setData(userDao.saveUser(user));
			logger.info("SAVED USER TO USER TABLE");
			return new ResponseEntity<ResponseStructure<Seller>>(responseStructure, HttpStatus.CREATED);
		}
		logger.warn("Email already Found");
		responseStructure.setData(u1);
		throw new NoSuchIdFoundException("Email is already Present");
	}

	public ResponseEntity<ResponseStructure<Seller>> updateUsetById(Seller user, int id) {
		Optional<Seller> user2 = userDao.getUsreById(id);
		ResponseStructure<Seller> responseStructure = new ResponseStructure<Seller>();

		if (user2.isPresent()) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(userDao.updateUser(user));
			logger.info("UPDATED USER");
			return new ResponseEntity<ResponseStructure<Seller>>(responseStructure, HttpStatus.OK);
		}
		logger.error("NO SUCH USER FOUND");
		throw new UnableToUpdateException();
	}

	public ResponseEntity<ResponseStructure<Seller>> getUserById(int id) {

		Optional<Seller> user = userDao.getUsreById(id);
		ResponseStructure<Seller> responseStructure = new ResponseStructure<Seller>();
		if (user.isPresent()) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FOUND");
			responseStructure.setData(user.get());
			logger.info("FOUND USER");
			return new ResponseEntity<ResponseStructure<Seller>>(responseStructure, HttpStatus.FOUND);
		}
		logger.error("NO SUCH ID FOUND");
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		Optional<Seller> user2 = userDao.getUsreById(id);

		if (user2.isPresent()) {
			userDao.deleteUser(user2.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData("Deleted");
			logger.warn("DELETED USER");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		logger.error("User not found");
		throw new UnableToDeleteException();
	}

	public ResponseEntity<ResponseStructure<Seller>> getUserbyEmail(String email, String password) {
		ResponseEntity<ResponseStructure<Seller>> entity;
		ResponseStructure<Seller> responseStructure = new ResponseStructure<Seller>();
		
		Seller user = userDao.getByEmail(email);
	
		List<Book> l1 = user.getBooks();
		if (user != null) {
			
			if (user.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("Login success");
				responseStructure.setData(user);
				logger.info("LOGIN SUCCESS");
				return entity = new ResponseEntity<ResponseStructure<Seller>>(responseStructure, HttpStatus.FOUND);
			} else {
				logger.warn("INVALID PASSWORD");
				throw new NoSuchIdFoundException("Invalid Password");
			}

		}
		logger.error("INVALID CREDENTIALS");
		throw new NoSuchIdFoundException("Provide Valid Credentials");

	}
}
