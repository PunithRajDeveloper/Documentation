package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.ProductDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;
@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		
	
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product detail saved sucessfully");
		responseStructure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Optional<Product> product = dao.findProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		

		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail received");
			responseStructure.setData(dao.findProductById(id).get());
		} 
		return new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> UpdateProduct(Product product, int id) {
		Optional<Product> product2 = dao.findProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
	
		if (product2 != null) {
			product.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Cart detail update Sucessfully");
			responseStructure.setData(dao.updateProduct(product));
		}
		return new ResponseEntity<ResponseStructure<Product>>(
				responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		Optional<Product> product3=dao.findProductById(id);
		
		if(product3!=null) {
			dao.deleteProduct(product3.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData("Deleted");
		return new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		}
		
		throw null;
	}
}
