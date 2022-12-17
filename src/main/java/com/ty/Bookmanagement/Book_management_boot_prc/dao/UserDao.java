package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	UserRepo userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public User updateUser(User user) {
		return userRepo.save(user);
	}

	public Optional<User> getUsreById(int id) {
		return userRepo.findById(id);

	}

	public void deleteUser(User user) {
		userRepo.delete(user);

	}
}
