package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.UserRepo;

public class UserDao {
	@Autowired
     UserRepo userRepo;
	
	public User saveUser(User user) {
	return	userRepo.save(user);
     }
	
	public User updateUser(User user) {
		return	userRepo.save(user);
	  }
	
	public User getUsreById(int id) {
		return  userRepo.findById(id).get();
		
	}
	
	public String  deleteUser(User user) {
		  userRepo.delete(user);
		  return "Deleted";
	}
}
