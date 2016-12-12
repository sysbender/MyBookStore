package com.voxwalker.bookstore.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 * map of cartItem
 */
public class Cart {
	
	Map<String, CartItem> map = new LinkedHashMap<>();
	// add item to cart
	public void add(CartItem cartItem){
		String book_id = cartItem.getBook().getBook_id();
		int count = cartItem.getCount();
		// if  book exist in cart , change count
		if(map.containsKey(book_id)){  
			map.get(book_id).setCount( map.get(book_id).getCount() + count); 
					
		}else{
			// book not exist in cart, put it to map
			map.put(cartItem.getBook().getBook_id(), cartItem);
		}
		
	}
	// remove item from cart
	public void delete(String book_id){
		map.remove(book_id);
		
	}
	
	// remove all items
	public void clear(){
		map.clear();		
	}

	// return list of item
	public Collection<CartItem> getCartItems(){		
		return map.values();
	}
	// return total for items in cart
	public double getTotal(){
		BigDecimal total =BigDecimal.valueOf(0);
		for(CartItem cartItem : map.values()){
			total = total.add(BigDecimal.valueOf(cartItem.getSubtotal())) ;
		}		
		return total.doubleValue();
	}
}
