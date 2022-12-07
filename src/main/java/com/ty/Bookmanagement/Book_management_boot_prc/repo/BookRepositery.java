package com.ty.Bookmanagement.Book_management_boot_prc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;

public interface BookRepositery extends JpaRepository<Book, Integer> {

	public Book getByTitle(String title);
	public Book getByCategory(String category);
}
