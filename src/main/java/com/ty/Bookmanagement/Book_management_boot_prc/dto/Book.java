package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please provide Title of the Book")
	private String title;
	@NotNull(message = "Please Provide The Suitable Catagory")
	private String category;
	@NotNull(message = "Enter the price")
	private double price;
	private String auther;
	private String publications;
	
		
}
