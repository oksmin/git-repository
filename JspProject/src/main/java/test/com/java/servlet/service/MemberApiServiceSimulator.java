package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.java.servlet.service.MemberApiService;
import com.java.servlet.service.impl.MemberApiServiceImpl;

class MemberApiServiceSimulator {
	
	private final MemberApiService service = MemberApiServiceImpl.getInstance();	
	
	
	@Test @Ignore
	void testGetMemberDual() {
		assertNotEquals(null, service.getMemberDual());
		System.out.println( new Gson().toJson(service.getMemberDual()));
	}

}
