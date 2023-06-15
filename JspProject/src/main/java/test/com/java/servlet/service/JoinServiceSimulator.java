package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.JoinService;
import com.java.servlet.service.impl.JoinServiceImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MemberVO;

class JoinServiceSimulator {
	
	JoinService service = JoinServiceImpl.getInstance();
	
	@Test @Ignore
	void testRegisterMember() {
		MemberVO vo = new MemberVO();
		vo.setName("잼민");
		vo.setJumin("0510101231211");
		vo.setId("jemminy012");
		vo.setPwd( SHAEncodeUtil.encodeSha("jem04") );
		
		assertEquals(1, service.registerMember(vo));  
	}

}
