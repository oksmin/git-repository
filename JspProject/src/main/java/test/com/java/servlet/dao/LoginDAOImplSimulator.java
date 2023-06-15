package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.LoginDAO;
import com.java.servlet.dao.impl.LoginDAOImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MemberVO;

class LoginDAOImplSimulator {
	
	LoginDAO dao = LoginDAOImpl.getInstance();
	LoginDAO dao2 = LoginDAOImpl.getInstance();
	
	@Test @Ignore
	void testReference() {
		assertEquals(dao, dao2);
	}
	
	@Test 
	void testSelectMember() {
		MemberVO vo = new MemberVO();
		vo.setId("jemminy01");
		vo.setPwd( SHAEncodeUtil.encodeSha("jem04") );
		
		assertEquals(1, dao.selectCountMember(vo));  
	}
	
	@Test @Ignore
	void testSelectMemberByIdAndPwd() {
		MemberVO vo = new MemberVO();
		vo.setId("jemminy01");
		vo.setPwd( SHAEncodeUtil.encodeSha("jem04") );
		
		dao.selectMemberByIdAndPwd(vo);
		assertEquals(vo, vo);
		
		System.out.println("여기- "+vo);
	}

}
