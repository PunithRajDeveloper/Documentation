package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ty.Bookmanagement.Book_management_boot_prc.util.AesEncryption;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Enter a valid name")
	@Size(min = 3, message = "Enter your full name")
	private String name;
	@NotNull(message = "Enter a valid addres to send orders")
	@Size(min = 10, message = "enter full address")
	private String address;
	@NotNull(message = "Enter an active phone number to contact")
	@Min(9)
	private long phone;

	@Convert(converter = AesEncryption.class)
	@NotNull
	@Email(message = "Enter valid mail")
	private String email;
	@NotNull(message = "Enter an active phone number to contact")
	@Convert(converter = AesEncryption.class)
	@Size(message = "minimum 6 charecters", min = 6)
	private String password;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Cart cart;
	private String date;

}
