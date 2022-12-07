package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private int id;
    private String name;
    private String address;
    private long phonNum;
    private String email;
    private String gender;
    
	
	
}
