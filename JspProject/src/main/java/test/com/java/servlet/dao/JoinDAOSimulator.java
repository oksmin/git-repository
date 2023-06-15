package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.JoinDAO;
import com.java.servlet.dao.impl.JoinDAOImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MemberVO;

class JoinDAOSimulator {
	
	JoinDAO dao = JoinDAOImpl.getInstance();
	
	@Test @Ignore
	void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setName("잼민");
		vo.setJumin("1410101231234");
		vo.setId("jemminy14");
		vo.setPwd(SHAEncodeUtil.encodeSha("jem04") );
		assertEquals( 1, dao.insertMember(vo) );
		
	}

}
