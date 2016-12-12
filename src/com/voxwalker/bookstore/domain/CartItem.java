package com.voxwalker.bookstore.domain;

import java.math.BigDecimal;

public class CartItem {
	private Book book; //
	private int count; // quantity
	
	
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// use big decimal
	public double getSubtotal(){
		BigDecimal bigd = BigDecimal.valueOf(book.getPrice()).multiply(BigDecimal.valueOf(count));
		return bigd.doubleValue();
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + "]";
	}
	
	
	
}
