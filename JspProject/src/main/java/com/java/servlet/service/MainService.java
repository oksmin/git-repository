package com.java.servlet.service;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.BoardVO;

public interface MainService {
	
	List<BoardVO> getAllBoard();
	
	int getCountAllBoard();
	
	List<BoardVO> getAllBoardByPage(PageMaker pageMaker);
}
