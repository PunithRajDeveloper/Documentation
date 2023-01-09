package com.ty.Bookmanagement.Book_management_boot_prc.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Seller;

public class SellerDetails implements UserDetails {

	Seller seller;


	public SellerDetails(Seller seller) {
		
		this.seller = seller;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	
	}

	@Override
	public String getPassword() {
		
		return this.seller.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.seller.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
