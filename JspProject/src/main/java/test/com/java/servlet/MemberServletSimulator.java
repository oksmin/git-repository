package test.com.java.servlet;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.java.servlet.MemberServlet;
import com.java.servlet.vo.MemberVO;

import mockit.Mocked;


class MemberServletSimulator {

	MemberServlet servlet = new MemberServlet();
	
	@Test
	void testDoGet() throws ServletException, IOException {
	    
		//System.out.println(servlet);
		
		servlet.doGet(null, null);
		//List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
		//assertNull(memberList);
	}

}
