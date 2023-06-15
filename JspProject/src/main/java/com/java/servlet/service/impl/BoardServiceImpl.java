package com.java.servlet.service.impl;

import com.java.servlet.dao.BoardDAO;
import com.java.servlet.dao.impl.BoardDAOImpl;
import com.java.servlet.service.BoardService;
import com.java.servlet.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	private static final BoardService instance = new BoardServiceImpl();
	private final BoardDAO dao = BoardDAOImpl.getInstance();
	
	private BoardServiceImpl() {
	}
	
	public static BoardService getInstance() {
		return instance;
	}
	
	@Override
	public BoardVO getBoard(int b_no) {
		return dao.selectBoard(b_no);
	}


	

}
