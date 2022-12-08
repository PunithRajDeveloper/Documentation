package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.CartRepo;
@Repository
public class CartDao {
@Autowired
    
private CartRepo cartrepo;

public Cart saveCart(Cart cart)
{
	return cartrepo.save(cart);
}
public Cart updateCart(Cart cart)
{
	return cartrepo.save(cart);
}

public Optional<Cart> findCartById(int id)
{
	return cartrepo.findById(id);
	
}
public String deleteCart(Cart cart)
{
	cartrepo.delete(cart);
	return "deleted";
}


}
