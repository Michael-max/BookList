package com.test.dao;

import java.util.List;

import com.test.entity.Books;

public interface BookDao {

	public int insert(Books book);
	public int delete(Books book);
	public int update(Books book);
	public List<Books> queryByPar(Books book);

}
