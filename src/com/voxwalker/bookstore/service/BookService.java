package com.voxwalker.bookstore.service;

import java.util.List;

import com.voxwalker.bookstore.dao.BookDao;
import com.voxwalker.bookstore.domain.Book;

public class BookService {
	
	private BookDao bookDao = new BookDao();
	public List<Book> findAll(){
		return bookDao.findAll();
	}
	
	
	public List<Book> findByCategory(String category_id) {
		return bookDao.findByCategory(category_id);

	}
	
	
	public Book load(String book_id) {
		 
		return bookDao.findByBid(book_id);
	}

	public List<String> findAllLanguage(){
		return bookDao.findAllLanguage();
		
	}


	public List<Book> findByLanguage(String language) {
		 
		return bookDao.findByLanguage(language);
	}
}
