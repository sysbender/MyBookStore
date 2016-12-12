package com.voxwalker.bookstore.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.voxwalker.bookstore.domain.Order;
import com.voxwalker.bookstore.domain.OrderItem;

import com.voxwalker.utils.JdbcTools;

public class OrderDao {
	private QueryRunner qr = new QueryRunner(JdbcTools.getDataSource());
	
	public void addOrder(Order order){
		try{
			System.out.println("orderDao.addOrder: " + order);
			String sql = "insert into t_order values(?,?,?,?,?,?)";
			// util date => sql date
			Timestamp timestamp = new Timestamp(order.getOrder_time().getTime());
			Object[]  params = {order.getOrder_id(), timestamp, order.getTotal(), 
					order.getState(), order.getOwner().getUser_id(), order.getAddress()};
			qr.update(sql, params);
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		
	}
	/**
	 * add items in order to t_item table
	 * @param orderItems
	 */
	public void addOrderItems(List<OrderItem> orderItems){
		 
		try{
			String sql = "insert into t_item values(?,?,?,?,?)";
			Object[][] params = new Object[orderItems.size()][];
			for (int i = 0 ; i< orderItems.size(); i++){
				OrderItem oi = orderItems.get(i);
				params[i] = new Object[]{oi.getItem_id(), oi.getCount(), 
						oi.getSubtotal(), oi.getOrder().getOrder_id(), 
						oi.getBook().getBook_id()};
			}
			// run batch sql
			qr.batch(sql, params);
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		
	}
	
	

	

	
	
	/**
	 * find all orders by user_id
	 * @param user_id
	 * @return
	 */
	public List<Order> findOrdersByUser(String user_id) {
		//  find order from t_order table
		String sql = "select * from t_order where user_id  = ?";
		try{
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), user_id);
			
			
			// find items for each order
			for(Order order : orderList){
				loadOrderItems(order);
			}
			System.out.println("orderDao.findOrdersByUser : " + orderList.size() );
			
			return orderList;
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}

	}
	/**
	 * load items for order
	 * @param order
	 */
	private void loadOrderItems(Order order) {
		BookDao bookDao = new BookDao();
		List<OrderItem> itemList = new ArrayList<>();
		//  
		String sql ="select i.item_id, b.book_id from t_item i , t_book b where  i.book_id=b.book_id  and order_id = ?";

		try{
			  List<Map<String , Object>> list= qr.query(sql, new MapListHandler() , order.getOrder_id());
			  System.out.println("****** order id = " + order.getOrder_id());
			  
			  
			for( Map<String, Object> m : list){

				 OrderItem item =  this.findItemById((String)m.get("item_id"));				
				 item.setOrder(order);
				 item.setBook(bookDao.findByBid((String) m.get("book_id") ));
				 
				 itemList.add(item);
				 System.out.println("                 >>>item id = " + m.get("item_id") + " book id = " + m.get("book_id"));
				 System.out.println("                 >>>item id = " + item);

			}
			
			order.setOrderItems(itemList); 
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		
		
	}
	
	/**
	 * find OrderItem by item_id
	 * @param item_id
	 * @return
	 */
	
	private OrderItem findItemById(String item_id){
		String sql ="select * from t_item where item_id = ?";
		try {
			return qr.query(sql, new BeanHandler<OrderItem>(OrderItem.class), item_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
