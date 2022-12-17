package com.ty.Bookmanagement.Book_management_boot_prc.dto;

import java.util.List;

<<<<<<< refs/remotes/origin/rajbala
=======
import javax.persistence.CascadeType;
import javax.persistence.Convert;
>>>>>>> local
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.ty.Bookmanagement.Book_management_boot_prc.util.AesEncryption;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "enter name of the seller")
    private String name;
	@NotNull(message = "Enter the present address")
<<<<<<< refs/remotes/origin/rajbala
    private String address;
    @NotNull(message = "Enter an active phone number to contact")
    private long phonNum;
    private String email;
    private String gender;
    
    
    @OneToMany
    private List<Book> books;   
	
	
=======
	private String address;
	@NotNull(message = "Enter an active phone number to contact")
	private long phonNum;
	@Convert(converter = AesEncryption.class)
	private String email;
	private String gender;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Book> books;

>>>>>>> local
}
