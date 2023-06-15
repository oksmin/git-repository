package com.java.servlet.dao;

import com.java.servlet.vo.BoardVO;

public interface BoardApiDAO {
	int updateBoard(BoardVO vo);
	int insertBoard(BoardVO vo);
	int deleteBoard(int b_no);
}
