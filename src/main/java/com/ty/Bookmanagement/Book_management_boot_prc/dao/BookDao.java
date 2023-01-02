package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Book;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.BookRepositery;

@Repository
public class BookDao {

	@Autowired
	private BookRepositery repositery;

	public Book saveBook(Book book) {
		return repositery.save(book);
	}

	public Optional<Book> getBookbyId(int id) {

		return repositery.findById(id);
	}

	public Book getBookbyCategory(String category) {
		return repositery.getByCategory(category);
	}

	public Book getBookByTitle(String title) {
		return repositery.getByTitle(title);
	}

	public String deleteBookbyId(int id) {
		repositery.deleteById(id);
		return "deleted";
	}

	public Book updateBookbyId(Book book) {
		return repositery.save(book);
	}
	
	public List<Book> findall()
	{
		return repositery.findAll();
	}
	public void deleteEntity(Book book)
	{
		 repositery.delete(book);
	}
}
