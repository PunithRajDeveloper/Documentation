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

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Product;
import com.ty.Bookmanagement.Book_management_boot_prc.service.ProductService;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;
@RestController
@RequestMapping("product")
public class ProductController {
@Autowired
 ProductService productservice;
	
	
	@PostMapping
	   public ResponseEntity<ResponseStructure<Product>> saveProduct (@RequestBody Product product){
		   return productservice.saveProduct(product);
		
	}
	   
	   @PutMapping
		public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@RequestParam int id)
		{
			return productservice.UpdateProductById(product, id);
		}
		@GetMapping
		public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id)
		{
			return productservice.getProductById(id);
		}
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<String>> deleteProductById(@RequestParam int id)
		{
			return productservice.deleteById(id);
		}

}
