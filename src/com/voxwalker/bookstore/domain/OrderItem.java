package com.voxwalker.bookstore.domain;

public class OrderItem {
	private String item_id;
	private int count;
	private double subtotal;
	private Order order;
	private Book book;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "OrderItem [item_id=" + item_id + ", count=" + count + ", subtotal=" + subtotal + ", order=" + order
				+ ", book=" + book + "]";
	}
	
	
	

}
