package com.voxwalker.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voxwalker.bookstore.domain.Book;
import com.voxwalker.bookstore.domain.Cart;
import com.voxwalker.bookstore.domain.CartItem;
import com.voxwalker.bookstore.service.BookService;
import com.voxwalker.utils.BaseServlet;

/**
 * Servlet implementation class CartServlet
 * 
 * when user login, add cart to session
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	
	public String  list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "f:/WEB-INF/jsps/cart/list.jsp";
	}
	
	
	public String  add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("cart servlet method : add !!!!!!!!!!!!!");
		// get cart from session
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// get book and count from form
		String book_id = request.getParameter("book_id");
		System.out.println("add to cart : book id= " + book_id );
		Book book = new BookService().load(book_id);
		int count  =  Integer.parseInt(request.getParameter("count")) ;
		// create cart
		
		CartItem cartItem = new CartItem();
		cartItem.setBook(book);
		cartItem.setCount(count);
		
		// add cartItem to cart.
		cart.add(cartItem);
		return "f:/WEB-INF/jsps/cart/list.jsp";
	}
	public String  delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get cart from session
		System.out.println("cart servlet method : delete !!!!!!!!!!!!!");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//
		String book_id = request.getParameter("book_id");
		cart.delete(book_id);
		return "f:/jsps/cart/list.jsp";
	}
	public String  clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cart servlet method : clear !!!!!!!!!!!!!");
		// get cart from session
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "f:/WEB-INF/jsps/cart/list.jsp";
	}
	

}
