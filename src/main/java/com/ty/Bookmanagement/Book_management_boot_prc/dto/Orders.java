package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
	private String name;
	@NotNull(message = "Enter a valid addres to send orders")
	private String address;
	@NotNull(message = "Enter an active phone number to contact")
	private long phone;
<<<<<<< punith
=======
	@Convert(converter = AesEncryption.class)
	@NotNull
	@Email(message = "Enter valid mail")
	private String email;
	@NotNull(message = "Enter an active phone number to contact")
	@Convert(converter = AesEncryption.class)
	@Size(message = "minimum 6 charecters", min = 6)
	private String password;
>>>>>>> local
	@OneToOne(cascade = CascadeType.REMOVE)
	private Cart cart;
	private String date;

}
