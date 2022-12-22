package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.CartDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dao.ProductDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToDeleteException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class CartService {
	public static final Logger logger=Logger.getLogger(CartService.class);
	
	@Autowired
	 CartDao dao;
	@Autowired
	ProductDao productDao;
	
	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart, int pid) {
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		
		Product product=productDao.getProductById(pid).get();
		List<Book> book=product.getBooks();
		product.setId(pid);
		List<Product> products=cart.getProducts();
		
		cart.setProducts(products);
		product.setId(pid);
		productDao.updateProduct(product);
		double totalcost=0;
		for(Book b : book)
		{
			totalcost=totalcost+(b.getPrice()*product.getQuantity());
		}
		cart.setTotalcost((totalcost*0.18)+totalcost);
				
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Cart detail saved sucessfully");
		responseStructure.setData(dao.saveCart(cart));
		logger.info("saved cart");
		return new ResponseEntity<ResponseStructure<Cart>>(responseStructure,
				HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Cart>> getCartById(int id) {
		Optional<Cart> cart = dao.getCartById(id);
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();

		if (cart.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail received");
			responseStructure.setData(cart.get());
			logger.info("found cart");
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure,
					HttpStatus.FOUND);
		} 
		logger.error("Id not found");
		throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<Cart>> UpdateCart(Cart cart, int id) {
       Optional<Cart> cart2=dao.getCartById(id);
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		
		if (cart2.isPresent()) {
			cart.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail update Sucessfully");
			responseStructure.setData(dao.updateCart(cart));
			logger.info("updated cart");
			return new ResponseEntity<ResponseStructure<Cart>>(
					responseStructure, HttpStatus.OK);
		} 
		logger.error("Unable to updated");
		throw new UnableToUpdateException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteById( int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		Optional<Cart> cart3 = dao.getCartById(id);

		if (cart3.isPresent()) {
			dao.deleteCart(cart3.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData("Deleted");
			logger.warn("deleted");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		logger.error("Unable to delete");
		throw new UnableToDeleteException("unable");

	}
}
