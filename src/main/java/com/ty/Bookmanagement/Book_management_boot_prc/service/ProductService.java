package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.BookDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dao.ProductDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToDeleteException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;
@Service
public class ProductService {
	@Autowired
	ProductDao dao;
	
	@Autowired
	BookDao bookDao;
	

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, String title) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		Book book=bookDao.getBookByTitle(title);
	
		List<Book> books=new ArrayList<Book>();
		books.add(book);
		 product.setBooks(books);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product detail saved sucessfully");
		responseStructure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Optional<Product> product = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		

		if (product.isPresent()) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Cart detail received");
			responseStructure.setData(product.get());
		
		return new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.FOUND);
	}
	  throw new NoSuchIdFoundException();
	}
	

	public ResponseEntity<ResponseStructure<Product>> UpdateProductById(Product product, int id) {
		Optional<Product> product2 = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
	
		if (product2.isPresent()) {
			product.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail update Sucessfully");
			responseStructure.setData(dao.updateProduct(product));
		
		return new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.OK);
	}
	  throw new UnableToUpdateException()	;
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		Optional<Product> product3=dao.getProductById(id);
		
		if(product3.isPresent()) {
			dao.deleteProduct(product3.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData("Deleted");
		return new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		}
		
		throw new UnableToDeleteException();
	}
}
