package com.test.dao.base;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	
	private Connection conn = null;

	public BaseDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws Exception{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
		return conn;
		
	}
	
	protected void closeConnection() {
		if(conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
}
