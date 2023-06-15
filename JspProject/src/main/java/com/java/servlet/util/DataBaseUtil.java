package com.java.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.vo.MemberVO;

public class DataBaseUtil {
	
	// DriverManager : driver download -> web-inf > lib -> ojdbc8.jar 를 넣는다.
	// Connection
	// Statement, PrepareStatement
	// ResultSet
	private static Connection connection;
	
	static {
		try {
			connection = connectionDB();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		System.out.println("connection - " + connection);
		if(connection == null || connection.isClosed()){
			connection = connectionDB();
		}
		return connection;
	}
	
	private static Connection connectionDB() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "C##SCOTT";
		String pwd = "tiger";
		return DriverManager.getConnection(url, id, pwd);
	}
	
	public static void destroyConnection() {
		if(connection != null) {
			try {  
				connection.close();	
				connection = null;
			}catch (SQLException e){
				e.printStackTrace(); }
			}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		String id = "bang0007";
		String pwd = "112233";
		String sql = "SELECT COUNT(1) FROM member\n"
				+ "	WHERE id = '" + id + "'\n"
						+ "		AND pwd = '"+ pwd + "'\n" 
			;
		
		sql = "SELECT m_no\r\n"
				+ "        ,name\r\n"
				+ "        ,jumin\r\n"
				+ "        ,id \r\n"
				+ "    FROM member\r\n"
				;
		
		try(	
				Connection conn = connectionDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
			){
			//1005	경문방	0008102330034	bang0007	112233
			//1020	경문방2	0008102330031	bang0001	112233
			
			List<MemberVO> memberList = new ArrayList<>();
			
			while( rs.next() ) {
				MemberVO vo = new MemberVO();
				vo.setM_no	( rs.getInt(1) 	);
				vo.setName	( rs.getString(2) );
				vo.setJumin	( rs.getString(3) );
				vo.setId	( rs.getString(4) );
				memberList.add(vo);
			}
			System.out.println(memberList);	
			/*
			
			System.out.println(conn);
			
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt == 1) {
				System.out.println("로그인성공");
			}else {
				System.out.println("로그인실패");
			}
			*/
			/*
			rs.close();
			stmt.close();
			conn.close();
			*/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
