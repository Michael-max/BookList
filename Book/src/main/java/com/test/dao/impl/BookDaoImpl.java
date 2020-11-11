package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.BookDao;
import com.test.dao.base.BaseDao;
import com.test.entity.Books;

public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public int insert(Books book) {
		Connection conn = null;
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false); 
			String sql = "INSERT INTO BOOKS(NAME,AUTHER) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, book.getName());
			ps.setObject(2, book.getAuther());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			} 
		} finally {
			super.closeConnection();
		}
		return 0;
	}

	@Override
	public int delete(Books book) {
		Connection conn = null;
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false); 
			String sql = "DELETE FROM BOOKS WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, book.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			} 
		} finally {
			super.closeConnection();
		}
		return 0;
	}

	@Override
	public int update(Books book) {
		Connection conn = null;
		try {
			conn = super.getConnection();
			conn.setAutoCommit(false); 
			String sql = "UPDATE BOOKS SET NAME = ?,AUTHER = ? WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, book.getName());
			ps.setObject(2, book.getAuther());
			ps.setObject(3, book.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			} 
		} finally {
			super.closeConnection();
		}
		return 0;
	}

	@Override
	public List<Books> queryByPar(Books book) {
		List<Books> books = new ArrayList<Books>();
		Connection conn = null;
		try {
			conn = super.getConnection();
			StringBuffer sql = new StringBuffer("SELECT ID,NAME,AUTHER,CREATE_TIME FROM BOOKS WHERE 1=1");
			if(book != null) {
				if(book.getId() != null) {
					sql.append(" AND ID = ?");
				}
				if(book.getName() != null) {
					sql.append(" AND NAME = ?");
				}
			}	
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			int index = 0;
			if(book != null) {
				if(book.getId() != null) {
					ps.setObject(++index, book.getId());
				}
				if(book.getName() != null) {
					ps.setObject(++index, book.getName());
				}
			}
			ResultSet rs = ps.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String auther = rs.getString("auther");
				String create_time = rs.getString("create_time");
				
				Books b = new Books();
				b.setId(id);
				b.setName(name);
				b.setAuther(auther);
				b.setCreate_time(sdf.parse(create_time));
			}
				
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		} finally {
			super.closeConnection();
		}
		return books;
	}

}