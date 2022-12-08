package com.ty.Bookmanagement.Book_management_boot_prc.service;

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
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<User>> updateUsetById(User user, int id) {
		User user2 = userDao.getUsreById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(userDao.updateUser(user));
		} else {
			return null;
		}

		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}
	
	public ResponseEntity<ResponseStructure<User>> getUsetById(int id) {
		
		User user=userDao.getUsreById(id);
		ResponseStructure<User>  responseStructure=new  ResponseStructure<User>();
		if(user!=null) {
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("FOUND");
		responseStructure.setData(userDao.getUsreById(id));
		}
		else {
			return null;
		}
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.FOUND);
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(User user ,int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		User  user2=userDao.getUsreById(id);
		
		if(user2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(userDao.deleteUser(user));
		}
		
		else {
			return null;
		}
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

}
