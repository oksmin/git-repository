package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.java.servlet.dao.MemberApiDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.BoardVO;

public class MemberApiDAOImpl implements MemberApiDAO{
	private static final MemberApiDAO instance = new MemberApiDAOImpl();
	
	private MemberApiDAOImpl() {}
	
	public static MemberApiDAO getInstance() {
		return instance;
	}
	
	@Override
	public JsonObject getMemberDual() {
		
		String sql = "SELECT '잼민' as name\r\n"
				+ "        ,ROUND ( months_between( sysdate, \r\n"
				+ "                                to_date( SUBSTR('9604041231234', 0, 6)\r\n"
				+ "                                         , 'RRMMDD') \r\n"
				+ "                                ) /12 \r\n"
				+ "                                    ) as age \r\n"
				+ "    FROM dual"
				;
		JsonObject jsonObj = null; 
		JsonArray list = null;
		
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				Statement stmt = conn.createStatement();
				){
				
				ResultSet rs = stmt.executeQuery(sql);
				jsonObj = new JsonObject();
				list = new JsonArray();
				
				while( rs.next() ) {
					JsonObject vo = new JsonObject();
					vo.addProperty("name", rs.getString("name"));
					vo.addProperty("age", rs.getInt("age"));

					list.add(vo);
				}
				jsonObj.add("list", list);
					 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonObj;
	}

	@Override
	public JsonObject getMember() {
		String sql = "SELECT name\r\n"
				+ "        ,ROUND ( months_between( sysdate, \r\n"
				+ "                                to_date( SUBSTR(jumin, 0, 6)\r\n"
				+ "                                         , 'RRMMDD') \r\n"
				+ "                                ) /12 \r\n"
				+ "                                    ) as age \r\n"
				+ "    FROM member"
				;
		JsonObject jsonObj = null; 
		JsonArray list = null;
		
		try(
				Connection conn = DBCP2Util.getConnection();//  DataBaseUtil
				Statement stmt = conn.createStatement();
				){
				
				ResultSet rs = stmt.executeQuery(sql);
				jsonObj = new JsonObject();
				list = new JsonArray();
				
				while( rs.next() ) {
					JsonObject vo = new JsonObject();
					vo.addProperty("name", rs.getString("name"));
					vo.addProperty("age", rs.getInt("age"));

					list.add(vo);
				}
				jsonObj.add("list", list);
					 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonObj;
	}

	

}
