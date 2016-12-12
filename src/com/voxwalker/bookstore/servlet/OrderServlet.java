package com.voxwalker.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voxwalker.bookstore.domain.Cart;
import com.voxwalker.bookstore.domain.CartItem;
import com.voxwalker.bookstore.domain.Order;
import com.voxwalker.bookstore.domain.OrderItem;
import com.voxwalker.bookstore.domain.User;
import com.voxwalker.bookstore.service.OrderService;
import com.voxwalker.utils.BaseServlet;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderService();
	



	/**
	 * create order from cart
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. get cart from session
		 * 2. create order from cart
		 * 3. add order to DB
		 * 4. add order to request and forward to /jsps/order/desc.jsp
		 */
		User user = (User)request.getSession().getAttribute("session_user");
		System.out.println("OrderServlet.add: user"+ user);
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		System.out.println("===*********************=============get cart from session");
		System.out.println("cart.getTotal: " + cart.getTotal());
		
		// order
		Order order = new Order();
		order.setOrder_id(UUID.randomUUID().toString().replaceAll("-", ""));
		order.setOrder_time(new Date());
		order.setState(1); // not pay
		order.setOwner(user);
		order.setTotal(cart.getTotal());
		order.setAddress("");
		
		// order items
		List<OrderItem> orderItems = new ArrayList<>();
		for(CartItem cartItem : cart.getCartItems()){
			// create orderItem
			OrderItem orderItem = new OrderItem();
			orderItem.setItem_id(UUID.randomUUID().toString().replaceAll("-", ""));
			orderItem.setOrder(order);
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setBook(cartItem.getBook());
			
			orderItems.add(orderItem); // add to list				
			 
		}
		
		// set order
		order.setOrderItems(orderItems);
		
		// clear cart
		cart.clear();
		
		// add to db
		orderService.add(order);
		
		// add order to request attribute
		request.setAttribute("order", order);
		
		
		return "f:/WEB-INF/jsps/order/desc.jsp";
	}

	public String getOrdersByUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. get session_user from session
		 * 2. get all orders by user: orderService.getOrdersByUser(String user_id) 
		 * 3. save listOrders to request, forword to /jsps/order/list.jsp
		 */
		User user = (User)request.getSession().getAttribute("session_user");
		if(user!=null){
		List<Order> orderList = orderService.findOrdersByUser(user.getUser_id());
		request.setAttribute("orderList", orderList);
		}
		
		return "f:/WEB-INF/jsps/order/list.jsp";
	}
}
