package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.CartRepo;

public class CartDao {
	@Autowired
	private CartRepo repository;
	
	public Cart saveCart(Cart cart) {
		return repository.save(cart);
		
	}
	
	public Cart updateCart(Cart cart) {
		return repository.save(cart);
		
	}
	
	public Cart getCartById(int id) {
		Optional<Cart> optional=repository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	
	public String deleteCartById(int id)
	{
		repository.deleteById(id);
		return "deleted";
		
	}	
	
}
