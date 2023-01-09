package com.ty.Bookmanagement.Book_management_boot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.SellerRepo;
import com.ty.Bookmanagement.Book_management_boot_prc.util.SellerDetails;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	SellerRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Seller seller=this.repo.getByEmail(username);
		if(seller==null)
		{
			throw new UsernameNotFoundException("No Email Found");
		}
		return new SellerDetails(seller);
	}

}
