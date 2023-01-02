package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.SellerRepo;

@Repository
public class SellerDao {
	@Autowired
	SellerRepo userRepo;

	public Seller saveUser(Seller user) {
		return userRepo.save(user);
	}

	public Seller updateUser(Seller user) {
		return userRepo.save(user);
	}

	public Optional<Seller> getUsreById(int id) {
		return userRepo.findById(id);

	}

	public void deleteUser(Seller user) {
		userRepo.delete(user);

	}
	
	public Seller getByEmail(String email)
	{
		return userRepo.getByEmail(email);
	}
}
