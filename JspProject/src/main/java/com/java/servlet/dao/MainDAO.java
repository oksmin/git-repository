package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.BoardVO;

public interface MainDAO {
	List<BoardVO> selectAllBoard();
	int seletCountAllBoard();
	List<BoardVO> selectAllBoardByPage(PageMaker pageMaker);
}
