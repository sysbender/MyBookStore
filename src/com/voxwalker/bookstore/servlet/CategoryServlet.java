package com.voxwalker.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voxwalker.bookstore.domain.Category;
import com.voxwalker.bookstore.service.CategoryService;
import com.voxwalker.utils.BaseServlet;

/**
 * Servlet implementation class CategoryServlet
 *  WebServlet("/CategoryServlet")
 */

public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private CategoryService categoryService = new CategoryService();
	
	 
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAll());
		response.setContentType("text/html");
		List<Category> cl = categoryService.findAll();
		for(Category c : cl){
			System.out.println(c.getCategory_name());
		}
		return "f:/jsps/left.jsp";
		
	}
	
	

}
