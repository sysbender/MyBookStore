package com.voxwalker.bookstore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.voxwalker.bookstore.domain.User;
import com.voxwalker.utils.JdbcTools;


public class UserDao {
	private QueryRunner qr = new QueryRunner(JdbcTools.getDataSource());
	
	/**
	 * find user by username
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		
		try{
			String sql = "select * from t_user where username = ?";
			return qr.query(sql, new BeanHandler<User>(User.class), username);
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}

	}
	/**
	 * find user by email
	 * @param email
	 * @return
	 */
	
	public User findByEmail(String email){
		try{
			String sql = "select * from t_user where email = ?";
			return qr.query(sql, new BeanHandler<User>(User.class), email);
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * add user to database 
	 * @param user
	 */
	public void add(User user){
		try{
			String sql = "insert into t_user values(?,?,?,?,?,?)";

			Object[] params = { user.getUser_id(),user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(), user.getState()};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	


}
