package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please provide Title of the Book")
	@Size(min = 1, message = "Enter a valid title")
	private String title;
	@NotNull(message = "Please Provide The Suitable Catagory")
	private String category;
	@NotNull(message = "Enter the price")
	private double price;
	private String auther;
	private String publications;
	
		
}
