package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.dao.MainDAO;
import com.java.servlet.dao.impl.MainDAOImpl;
import com.java.servlet.service.MainService;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.BoardVO;

public class MainServiceImpl implements MainService {

	private static final MainService instance = new MainServiceImpl();
	private final MainDAO dao = MainDAOImpl.getInstance();
	
	private MainServiceImpl() { }
	
	public static MainService getInstance() {
		return instance;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.selectAllBoard();
	}

	@Override
	public int getCountAllBoard() {
		return dao.seletCountAllBoard();
	}

	@Override
	public List<BoardVO> getAllBoardByPage(PageMaker pageMaker) {
		return dao.selectAllBoardByPage(pageMaker);
	}
	
}
