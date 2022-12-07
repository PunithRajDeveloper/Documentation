package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Orders;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.OrderRepo;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.ProductRepo;

public class ProductDao {
	@Autowired
	private ProductRepo repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
		
	}
	
	public Product updateProduct(Product product) {
		return repository.save(product);
		
	}
	
	public Product getProductById(int id) {
		Optional<Product> optional=repository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	
	public String deleteProductById(int id)
	{
		repository.deleteById(id);
		return "deleted";
		
	}	
}
