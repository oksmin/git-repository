package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.BoardDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	private static final BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {
	}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	@Override
	public BoardVO selectBoard(int b_no) {
		String sql = "SELECT b_no\r\n"
				+ "        ,title\r\n"
				+ "        ,content\r\n"
				+ "        ,reg_date\r\n"
				+ "        ,up_date\r\n"
				+ "        ,(SELECT id FROM member WHERE m_no=1042) as id\r\n"
				+ "    FROM board WHERE b_no = ?"
				;
		BoardVO vo = null;
		
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setInt(1, b_no);
			
				ResultSet rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					vo = new BoardVO();
					vo.setB_no(rs.getInt("b_no"));
					vo.setTitle(rs.getString("title"));
					vo.setId(rs.getString("id"));
					vo.setContent(rs.getString("content"));
					vo.setReg_date(rs.getDate("reg_date"));
					vo.setUp_date(rs.getDate("up_date"));
				}
				rs.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
