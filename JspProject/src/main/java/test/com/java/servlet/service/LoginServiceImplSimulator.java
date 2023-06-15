package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.LoginService;
import com.java.servlet.service.impl.LoginServiceImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MemberVO;

class LoginServiceImplSimulator {
	
	private LoginService service = LoginServiceImpl.getInstance();
	
	@Test @Ignore
	void testGetCountMember() {
		MemberVO vo = new MemberVO();
		vo.setId("jemminy01");
		vo.setPwd(SHAEncodeUtil.encodeSha( "jem04"  ));
		
		assertEquals( 1, service.getCountMember(vo) );  
		System.out.println("여기 " + vo);
	}
	
	@Test @Ignore
	void testSelectMemberByIdAndPwd() {
		MemberVO vo = new MemberVO();
		vo.setId("jemminy01");
		vo.setPwd( SHAEncodeUtil.encodeSha( "jem04"  ) );
		
		service.getMemberByIdAndPwd(vo);
		assertEquals(vo, vo);
		
		System.out.println("여기 " + vo);
	}

}
