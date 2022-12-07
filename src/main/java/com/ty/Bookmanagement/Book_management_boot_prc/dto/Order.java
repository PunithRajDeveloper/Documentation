package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "enter name of the Orderer")
	private String name;
	@NotNull(message = "provide Address to send the ordered Books")
	private String address;
	@NotNull(message = "Provide active Phone number to contact")
	private long phone;
	private String email;
	private double totalcost;
	
	@OneToMany
	private List<Cart> cart;

}
