package com.ty.Bookmanagement.Book_management_boot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("product")
public class ProductController {
@Autowired
 ProductService productservice;
	
	
@ApiOperation(value = "save product", notes = "its used to save product")
@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 202, message = "accepted"),
		@ApiResponse(code = 203, message = "non-authoritataive information"),
		@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
		@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
		@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
		@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
		@ApiResponse(code = 408, message = "request timeout"),
		@ApiResponse(code = 500, message = "imternal server error"), })
@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
	   public ResponseEntity<ResponseStructure<Product>> saveProduct (@RequestBody Product product,@RequestParam String title){
		   return productservice.saveProduct(product,title);
		
	}
	   
@ApiOperation(value = "update product", notes = "its user to update product")
@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 202, message = "accepted"),
		@ApiResponse(code = 203, message = "non-authoritataive information"),
		@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
		@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
		@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
		@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
		@ApiResponse(code = 408, message = "request timeout"),
		@ApiResponse(code = 500, message = "imternal server error"), })
@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@RequestParam int id)
		{
			return productservice.UpdateProductById(product, id);
		}
@ApiOperation(value = "used to get prodct", notes = "its used to get used get product data by id")
@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 202, message = "accepted"),
		@ApiResponse(code = 203, message = "non-authoritataive information"),
		@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
		@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
		@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
		@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
		@ApiResponse(code = 408, message = "request timeout"),
		@ApiResponse(code = 500, message = "imternal server error"), })
@GetMapping( produces = {
		MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id)
		{
			return productservice.getProductById(id);
		}
		
@ApiOperation(value = "user to delete product", notes = "its used delete the product")
@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 202, message = "accepted"),
		@ApiResponse(code = 203, message = "non-authoritataive information"),
		@ApiResponse(code = 302, message = "found"), @ApiResponse(code = 304, message = "not spacified"),
		@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "unathorized"),
		@ApiResponse(code = 402, message = "payment requried"), @ApiResponse(code = 403, message = "forbidden"),
		@ApiResponse(code = 404, message = "not found"), @ApiResponse(code = 405, message = "method not allowed"),
		@ApiResponse(code = 408, message = "request timeout"),
		@ApiResponse(code = 500, message = "imternal server error"), })
@DeleteMapping
		public ResponseEntity<ResponseStructure<String>> deleteProductById(@RequestParam int id)
		{
			return productservice.deleteById(id);
		}

}
