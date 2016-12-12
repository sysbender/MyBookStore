package com.voxwalker.bookstore.domain;

import java.util.Date;
import java.util.List;

public class Order {
	private String order_id;
	private Date order_time;
	private double total;
	private int state; // not pay, payed, 
	private User owner;
	private String address;
	
	private List<OrderItem> orderItems;
	
	
	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_time=" + order_time + ", total=" + total + ", state=" + state
				+ ", owner=" + owner + ", address=" + address + "]";
	}
	
	
	
	
	

}
