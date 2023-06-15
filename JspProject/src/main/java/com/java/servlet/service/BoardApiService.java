package com.java.servlet.service;

import com.java.servlet.vo.BoardVO;

public interface BoardApiService {
	int modifyBoard(BoardVO vo);
	
	int registerBoard(BoardVO vo);
	
	int removeBoard(int b_no);
}
