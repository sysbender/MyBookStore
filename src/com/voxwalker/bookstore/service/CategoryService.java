package com.voxwalker.bookstore.service;

import java.util.List;

import com.voxwalker.bookstore.dao.CategoryDao;
import com.voxwalker.bookstore.domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	public List<Category> findAll() {
		 
		return categoryDao.findAll();
	}
	

}
