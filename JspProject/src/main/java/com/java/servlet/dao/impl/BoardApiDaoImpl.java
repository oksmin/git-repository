package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.BoardApiDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.BoardVO;

public class BoardApiDaoImpl implements BoardApiDAO{
	
	private static final BoardApiDAO instance = new BoardApiDaoImpl();

	private BoardApiDaoImpl() {
	}
	
	public static BoardApiDAO getInstance() {
		return instance;
	}
	
	@Override
	public int updateBoard(BoardVO vo) {
		int result = 0;
		String sql = "UPDATE board\r\n"
				+ "    SET title = ?\r\n"
				+ "    , content = ?\r\n"
				+ "    , up_date = sysdate\r\n"
				+ "    WHERE b_no = ?"
				;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getB_no());
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		
		int result = 0;
		String sql = "INSERT INTO board( b_no\r\n"
					+ "                    ,title\r\n"
					+ "                    ,content\r\n"
					+ "                    ,reg_date\r\n"
					+ "                    ,up_date\r\n"
					+ "                    ,m_no\r\n"
					+ "                    )    \r\n"
					+ "    values(\r\n"
					+ "            seq_board_bno.NEXTVAL\r\n"
					+ "            ,?\r\n"
					+ "            ,?\r\n"
					+ "            ,sysdate\r\n"
					+ "            ,null\r\n"
					+ "            ,(SELECT m_no FROM member WHERE id = ?) -- m_no\r\n"
					+ "    \r\n"
					+ "    )"
					;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getId());
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteBoard(int b_no) {
		
		int result = 0;
		String sql = "DELETE FROM board WHERE b_no = ?"
					;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setInt(1, b_no);
				
				result = pstmt.executeUpdate();
				System.out.println("result - " + result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
