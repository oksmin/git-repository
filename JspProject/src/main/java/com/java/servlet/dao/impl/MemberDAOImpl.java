package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.MemberDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public List<MemberVO> selectMemberList() {
		List<MemberVO> memberList = null;
		
		String sql = "SELECT m_no\r\n"
				+ "        ,name\r\n"
				+ "        ,jumin\r\n"
				+ "        ,id \r\n"
				+ "    FROM member"
				;
		
		try(
				Connection connection = DBCP2Util.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		){
			memberList = new ArrayList();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setM_no	( rs.getInt(1) 	);
				vo.setName	( rs.getString(2) );
				vo.setJumin	( rs.getString(3) );
				vo.setId	( rs.getString(4) );
				memberList.add(vo);
			}
			
			//DataBaseUtil.destroyConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	
	
	
	/*
	@Override
	public List<MemberVO> selectMemberList() {
		List<MemberVO> memberList = null;
		
		String sql = "SELECT m_no\r\n"
				+ "        ,name\r\n"
				+ "        ,jumin\r\n"
				+ "        ,id \r\n"
				+ "    FROM member"
				;
		
		try(
				Connection connection = DataBaseUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		){
			memberList = new ArrayList();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setM_no	( rs.getInt(1) 	);
				vo.setName	( rs.getString(2) );
				vo.setJumin	( rs.getString(3) );
				vo.setId	( rs.getString(4) );
				memberList.add(vo);
			}
			
			//DataBaseUtil.destroyConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	*/

}
