package com.java.servlet.dao;

import com.java.servlet.vo.BoardVO;

public interface BoardDAO {
	BoardVO selectBoard(int b_no);
}
