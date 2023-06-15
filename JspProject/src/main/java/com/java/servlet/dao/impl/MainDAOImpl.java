package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.MainDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.BoardVO;

public class MainDAOImpl implements MainDAO {
	
	private static final MainDAO instance = new MainDAOImpl();
	
	private MainDAOImpl() {
	}
	
	public static MainDAO getInstance() {
		return instance;
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		
		String sql = "SELECT b_no\r\n"
					+ "        ,title\r\n"
					+ "        ,content\r\n"
					+ "        ,reg_date\r\n"
					+ "        ,up_date\r\n"
					+ "        ,(SELECT id FROM member WHERE  m_no = a.m_no ) as id --scalar 쿼리\r\n"
					+ "    FROM board a"
					;
		List<BoardVO> list = null;
		
		try(
				Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
				Statement stmt = conn.createStatement();
				){
				
				ResultSet rs = stmt.executeQuery(sql);
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					BoardVO vo = new BoardVO();
					vo.setB_no(rs.getInt("b_no"));
					vo.setTitle(rs.getString("title"));
					vo.setId(rs.getString("id"));
					vo.setReg_date(rs.getDate("reg_date"));
					vo.setUp_date(rs.getDate("up_date"));
					
					list.add(vo);
				}
				rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int seletCountAllBoard() {
		int result = 0;
		String sql = "SELECT COUNT(1) \r\n"
						+ "    FROM board "
					;
		try(	Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DataBaseUtil
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
				
				if( rs.next() ) {
					result = rs.getInt(1);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
			
		return result;
	}

	@Override
	public List<BoardVO> selectAllBoardByPage(PageMaker pageMaker) {
		String sql = "SELECT \r\n"
				+ "        * \r\n"
				+ "    FROM (\r\n"
				+ "            SELECT /*+ INDEX (board index_board_bno_pk) */\r\n"
				+ "                    ROWNUM as rn\r\n"
				+ "                    ,b_no\r\n"
				+ "                    ,title\r\n"
				+ "                    ,content\r\n"
				+ "                    ,reg_date\r\n"
				+ "                    ,up_date\r\n"
				+ "                    ,(SELECT id FROM member WHERE m_no=1042) as id\r\n"
				+ "                FROM board\r\n"
				+ "                WHERE ROWNUM <= ( ? * ? )   -- page 1=10, 2=20, 3=30  page * 10, 10: 페이지당 게시글 갯수\r\n"
				+ "            )\r\n"
				+ "    WHERE rn > ( ( ? - 1 ) * ? )"
				;
		
		List<BoardVO> list = null;
		ResultSet rs = null;
		try(	Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, pageMaker.getCri().getPageNum());
			pstmt.setInt(2, pageMaker.getCri().getAmount());
			pstmt.setInt(3, pageMaker.getCri().getPageNum());
			pstmt.setInt(4, pageMaker.getCri().getAmount());
			
			rs = pstmt.executeQuery();
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					BoardVO vo = new BoardVO();
					vo.setB_no(rs.getInt("b_no"));
					vo.setTitle(rs.getString("title"));
					vo.setId(rs.getString("id"));
					vo.setReg_date(rs.getDate("reg_date"));
					vo.setUp_date(rs.getDate("up_date"));
					
					list.add(vo);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) { try {	rs.close();		 	} catch (SQLException e) {} }
			//if(pstmt != null) { try {	pstmt.close();	} catch (SQLException e) {} }
			/* if(conn != null) { try { conn.close(); } catch (SQLException e) {} } */
		}
		return list;
	}
	
	
}
