package com.java.servlet.service.impl;

import com.java.servlet.dao.BoardApiDAO;
import com.java.servlet.dao.impl.BoardApiDaoImpl;
import com.java.servlet.service.BoardApiService;
import com.java.servlet.vo.BoardVO;

public class BoardApiServiceImpl implements BoardApiService{
	private static final BoardApiService instance = new BoardApiServiceImpl();
	private final BoardApiDAO dao = BoardApiDaoImpl.getInstance();
	
	private BoardApiServiceImpl() {
	}
	
	public static BoardApiService getInstance() {
		return instance;
	}

	@Override
	public int modifyBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int registerBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int removeBoard(int b_no) {
		return dao.deleteBoard(b_no);
	}
}
