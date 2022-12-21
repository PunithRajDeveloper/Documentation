package com.ty.Bookmanagement.Book_management_boot_prc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
	public User getByEmail(String email);


}
