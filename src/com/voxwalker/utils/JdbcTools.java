package com.voxwalker.utils;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcTools {
	private static ComboPooledDataSource dataSource = null;

	public static DataSource getDataSource() {
		if (dataSource == null) {
			
			try {
				dataSource = new ComboPooledDataSource();
				return dataSource;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} // loads the jdbc driver

		} else {
			return dataSource;
		}

	}



}
/**
 * oracle url: "jdbc:oracle:thin:@myhost:1521:orcl" oracle class:
 * "oracle.jdbc.OracleDriver"
 * 
 * mysql url: jdbc:mysql://localhost:3306/myDBName mysql class:
 * com.mysql.jdbc.Driver
 * 
 * sqlite url: "jdbc:sqlite:C:/work/mydatabase.db" sqlite class:
 * "org.sqlite.JDBC"
 * 
 * 
 * @author jason
 *
 */