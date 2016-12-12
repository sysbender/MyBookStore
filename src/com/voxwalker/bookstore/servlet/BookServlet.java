package com.voxwalker.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voxwalker.bookstore.service.BookService;
import com.voxwalker.utils.BaseServlet;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	
	/**
	 * list all books
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bookList", bookService.findAll());
		System.out.println("book in list = " + bookService.findAll().size());
		return "f:/jsps/book/list.jsp";
		
	}
	
	
	public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category_id = request.getParameter("category_id");
		request.setAttribute("bookList", bookService.findByCategory(category_id));
		
		return "f:/jsps/book/list.jsp";
		
	}
	
	
	public String findByLanguage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = request.getParameter("language");
		request.setAttribute("bookList", bookService.findByLanguage(language));
		
		return "f:/jsps/book/list.jsp";
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return 
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_id = request.getParameter("book_id");
		request.setAttribute("book", bookService.load(book_id));
		System.out.println(bookService.load(book_id));
		
		return "f:/jsps/book/desc.jsp";
		
	}
}
