package com.ty.Bookmanagement.Book_management_boot_prc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer>{

	
	public Seller getByEmail(String email);


}
