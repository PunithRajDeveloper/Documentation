package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.UserDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SAVED");
		responseStructure.setData(userDao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUsetById(User user, int id) {
		Optional<User> user2 = userDao.getUsreById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		if (user2.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(userDao.updateUser(user));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {

		Optional<User> user = userDao.getUsreById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user.isPresent()) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FOUND");
			responseStructure.setData(user.get());

			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		}
		throw null;
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		Optional<User> user2 = userDao.getUsreById(id);

		if (user2.isPresent()) {
			userDao.deleteUser(user2.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData("Deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

}
