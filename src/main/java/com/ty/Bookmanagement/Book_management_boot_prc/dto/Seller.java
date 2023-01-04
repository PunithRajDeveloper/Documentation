package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import java.util.List;

import javax.persistence.Convert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ty.Bookmanagement.Book_management_boot_prc.util.AesEncryption;

import lombok.Data;

@Data
@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "enter name of the seller")
	@Size(min = 3, message = "name entered must be greater than 3 letters")
	private String name;
	@NotNull(message = "Enter the present address")
	@Size(min = 10, message = "enter accurte location with pincode")
	private String address;
	@NotNull(message = "Enter an active phone number to contact")
	@Convert(converter = AesEncryption.class)
	@Size(message = "minimum 6 charecters", min = 6)
	private String password;
	@Min(10)
	private long phonNum;
	@Convert(converter = AesEncryption.class)
	@NotNull
	@Email(message = "Enter valid mail")
	private String email;
	@NotBlank(message = "Enter a valid gender")
	private String gender;

	@OneToMany
	private List<Book> books;

}
