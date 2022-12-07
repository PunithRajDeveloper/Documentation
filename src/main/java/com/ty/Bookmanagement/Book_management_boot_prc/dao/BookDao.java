package com.ty.Bookmanagement.Book_management_boot_prc.dao;

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

	public Book getBookbyId(int id) {
		Optional<Book> optional = repositery.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
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
}
