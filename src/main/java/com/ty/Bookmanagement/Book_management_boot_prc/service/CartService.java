package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.CartDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;
@Service
public class CartService {
	@Autowired
	private CartDao dao;
	

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart) {
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		
		ResponseEntity<ResponseStructure<Cart>> entity = new ResponseEntity<ResponseStructure<Cart>>(
		responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Cart detail saved sucessfully");
		responseStructure.setData(dao.saveCart(cart));
		return entity;
	}
	
	public ResponseEntity<ResponseStructure<Cart>> getCartById(int id) {
	      Optional<Cart> cart = dao.findCartById(id);
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Cart>> entity = new ResponseEntity<ResponseStructure<Cart>>(
				responseStructure, HttpStatus.OK);

		if (cart.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail received");
			responseStructure.setData(cart.get());
		} else {
			return null;
		}

		return entity;
	}

	public ResponseEntity<ResponseStructure<Cart>> UpdateCart(Cart cart, int id) {
       Optional<Cart> cart2=dao.findCartById(id);
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Cart>> entity = new ResponseEntity<ResponseStructure<Cart>>(
				responseStructure, HttpStatus.OK);
		if (cart2 != null) {
			cart.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail update Sucessfully");
			responseStructure.setData(dao.updateCart(cart));
		} else {
			return null;
		}

		return entity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(Cart cart ,int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		Optional<Cart> cart3=dao.findCartById(id);
		
		if(cart3!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.deleteCart(cart));
		}
		
		else {
			return null;
		}
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}
}


