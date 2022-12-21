package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.UserDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToDeleteException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class UserService {
	
	private static final Logger logger=Logger.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		User u1=userDao.getEmail(user.getEmail());
		if(u1==null)
		{
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("SAVED");
			responseStructure.setData(userDao.saveUser(user));
			logger.info("SAVED USER TO USER TABLE");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
		}
		logger.warn("Email already Found");
		responseStructure.setData(u1);
		throw new NoSuchIdFoundException("Email is already Present");		
	}

	public ResponseEntity<ResponseStructure<User>> updateUsetById(User user, int id) {
		Optional<User> user2 = userDao.getUsreById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		if (user2.isPresent()) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(userDao.updateUser(user));
			logger.info("UPDATED USER");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}
		logger.error("NO SUCH USER FOUND");
		throw new UnableToUpdateException();
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {

		Optional<User> user = userDao.getUsreById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user.isPresent()) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FOUND");
			responseStructure.setData(user.get());
			logger.info("FOUND USER");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		}
		logger.error("NO SUCH ID FOUND");
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		Optional<User> user2 = userDao.getUsreById(id);

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
public ResponseEntity<ResponseStructure<User>> getUserbyEmail(String email, String password)
{
	ResponseEntity<ResponseStructure<User>> entity;
	ResponseStructure<User> responseStructure=new ResponseStructure<User>();
	User user=userDao.getEmail(email);
	if(user!=null)
	{
		if(user.getPassword().equals(password))
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Login success");
			responseStructure.setData(user);
			logger.info("LOGIN SUCCESS");
			return entity=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			logger.warn("INVALID PASSWORD");
			throw new NoSuchIdFoundException("Invalid Password");
		}
		
	}
	logger.error("INVALID CREDENTIALS");
	throw new NoSuchIdFoundException("Provide Valid Credentials");
	
}
}
