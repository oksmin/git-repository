package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.java.servlet.service.MemberService;
import com.java.servlet.service.impl.MemberServiceImpl;

class MemberServiceSimulator {
	
	MemberService service = new MemberServiceImpl();
	
	@Test
	void testGetMemberList() {
		assertNotNull(service.getMemberList());
		
	}

}
