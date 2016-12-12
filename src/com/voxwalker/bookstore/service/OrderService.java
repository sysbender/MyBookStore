package com.voxwalker.bookstore.service;

import java.util.List;

import com.voxwalker.bookstore.dao.OrderDao;
import com.voxwalker.bookstore.domain.Order;

public class OrderService {
	private OrderDao orderDao = new OrderDao();
	public void add(Order order){
		
		// needed to add transaction support
		try{
			orderDao.addOrder(order);
			orderDao.addOrderItems(order.getOrderItems());
			
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}
		
	}
	public List<Order> findOrdersByUser(String user_id) {
		//  
		return orderDao.findOrdersByUser(user_id);
	}

}
