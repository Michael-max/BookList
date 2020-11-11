package com.test.service.impl;

import java.util.List;

import com.test.dao.BookDao;
import com.test.dao.impl.BookDaoImpl;
import com.test.entity.Books;
import com.test.service.BookService;

public class BookServiceImpl implements BookService{

	private BookDao dao = new BookDaoImpl();

	@Override
	public int insert(Books book) {
		// TODO 自动生成的方法存根
		return dao.insert(book);
	}

	@Override
	public int delete(Books book) {
		// TODO 自动生成的方法存根
		return dao.delete(book);
	}

	@Override
	public int update(Books book) {
		// TODO 自动生成的方法存根
		return dao.update(book);
	}

	@Override
	public List<Books> queryByPar(Books book) {
		// TODO 自动生成的方法存根
		return dao.queryByPar(book);
	}
}
