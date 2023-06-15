package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.JoinDAO;
import com.java.servlet.dao.LoginDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MemberVO;

public class LoginDAOImpl implements LoginDAO {

private static final LoginDAO instance = new LoginDAOImpl();
	
	private LoginDAOImpl() {}
	
	public static LoginDAO getInstance() {
		return instance;
	}
	
	@Override
	public int selectCountMember(MemberVO vo) {
		// 여기는 selectMember 하는 자리, 나중에 적기
		int result = 0;
		
		String sql = "SELECT COUNT(1) FROM  member\r\n"
						+ "    WHERE (id, pwd) IN ( (?, ?) )"
						;
		
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				System.out.println(pstmt);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
			
				ResultSet rs = pstmt.executeQuery();
				if( rs.next() ) {
					result = rs.getInt(1);
				}
				System.out.println("result - "+result);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void selectMemberByIdAndPwd(MemberVO vo) {
		
		String sql = "SELECT * FROM  member\r\n"
				+ "    WHERE (id, pwd) IN ( (?, ?) )"
				;

		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				System.out.println(pstmt);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
			
				ResultSet rs = pstmt.executeQuery();
				if( rs.next() ) {
					vo.setM_no( rs.getInt("m_no") );
					vo.setName( rs.getString("name") );
					vo.setJumin( rs.getString("jumin") );
				}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
