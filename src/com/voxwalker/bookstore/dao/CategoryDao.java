package com.voxwalker.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.voxwalker.bookstore.domain.Category;
import com.voxwalker.utils.JdbcTools;


public class CategoryDao {
	
	private QueryRunner qr = new QueryRunner(JdbcTools.getDataSource());

	public List<Category> findAll() {
		String sql = "select * from t_category";
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			 
			throw new RuntimeException(e);
		}
	}
	

}
