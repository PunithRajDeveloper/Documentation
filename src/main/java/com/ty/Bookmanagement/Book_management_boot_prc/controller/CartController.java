package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.service.CartService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@RestController
@RequestMapping("cart")
public class CartController {
@Autowired
CartService cartService;
   
   @PostMapping
   public ResponseEntity<ResponseStructure<Cart>> saveCart (@RequestBody Cart cart){
	   return cartService.saveCart(cart);
	
}
   
   @PutMapping
	public ResponseEntity<ResponseStructure<Cart>> updateItems(@RequestBody Cart cart,@RequestParam int id)
	{
		return cartService.UpdateCart(cart, id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Cart>> getCartById(@RequestParam int id)
	{
		return cartService.getCartById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteCartById(@RequestParam int id)
	{
		return cartService.deleteById(id);
	}

   
}
