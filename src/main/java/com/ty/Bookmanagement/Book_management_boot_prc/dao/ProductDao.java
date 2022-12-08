package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.ProductRepo;
@Repository
public class ProductDao {
	@Autowired
    
	private ProductRepo productrepo;

	public Product saveProduct(Product product)
	{
		return productrepo.save(product);
	}
	public Product updateProduct(Product product)
	{
		return productrepo.save(product);
	}

	public Optional<Product> findProductById(int id)
	{
		return productrepo.findById(id);
		
	}
	public String deleteProduct(Product product)
	{
		productrepo.delete(product);
		return "deleted";
	}
}
