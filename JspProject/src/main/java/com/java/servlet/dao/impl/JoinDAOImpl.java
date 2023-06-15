package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.servlet.dao.JoinDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MemberVO;

public class JoinDAOImpl implements JoinDAO {
	
	private static final JoinDAO instance = new JoinDAOImpl();
	
	private JoinDAOImpl() {}
	
	public static JoinDAO getInstance() {
		return instance;
	}
	
	@Override
	public int insertMember(MemberVO member)  {
		int result = 0;
		
		String sql = "INSERT INTO member(m_no, name, jumin, id, pwd)\r\n"
				+ "        VALUES(\r\n"
				+ "                seq_member_mno.nextval"
				+ "                ,?\r\n"
				+ "                ,?\r\n"
				+ "                ,?\r\n"
				+ "                ,?\r\n"
				+ "        )";
		
		try(
				Connection conn = DBCP2Util.getConnection();//DataBaseUtil, DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				System.out.println(pstmt);
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getJumin());
				pstmt.setString(3, member.getId());
				pstmt.setString(4, member.getPwd());
			
				result = pstmt.executeUpdate();
				System.out.println("result - "+result);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	

}
