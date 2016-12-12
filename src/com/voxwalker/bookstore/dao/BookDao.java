package com.voxwalker.bookstore.dao;

import java.sql.SQLException;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;


import com.voxwalker.bookstore.domain.Book;
import com.voxwalker.utils.JdbcTools;


public class BookDao {
	private QueryRunner qr = new QueryRunner(JdbcTools.getDataSource());
	
	/**
	 * search all books
	 * @return
	 */
	public List<Book> findAll(){
		String sql = "Select * from t_book";
		try{
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
			
		}catch(SQLException se){
			throw new RuntimeException(se);
		}
	}

	/**
	 * search books by category
	 * @param cid
	 * @return
	 */
	public List<Book> findByCategory(String category_id) {
		 
		String sql = "Select * from t_book where category_id = ?";
		System.out.println("category_id = " + category_id);
		try{
			
			return qr.query(sql, new BeanListHandler<Book>(Book.class), category_id);
			
			
		}catch(SQLException se){
			throw new RuntimeException(se);
		}
	}

	public Book findByBid(String book_id) {
		 
		String sql = "Select * from t_book where book_id = ?";
		try{
			return qr.query(sql, new BeanHandler<Book>(Book.class), book_id);
			
		}catch(SQLException se){
			throw new RuntimeException(se);
		}
	}

	public List<String> findAllLanguage() {
		 String sql = "select DISTINCT language from t_book ";
		 try{

			 List<String> list=   qr.query(sql, new  ColumnListHandler<String>(1));

			 System.out.println("language number = " + list.size() );
			 for(String s : list){
				 System.out.println("language = " +s);
			 }
			 return list;
		 }catch(SQLException se){
			 se.printStackTrace();
			 throw new RuntimeException(se);
		 }
		
	}

	public List<Book> findByLanguage(String language) {
		String sql = "select * from t_book where language = ?";
		try{
			return qr.query(sql, new BeanListHandler<Book>(Book.class), language);
		}catch(SQLException se){
			throw new RuntimeException();
		}
		 
	}
	

}
