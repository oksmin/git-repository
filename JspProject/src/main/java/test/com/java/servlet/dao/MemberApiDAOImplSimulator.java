package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.java.servlet.dao.MemberApiDAO;
import com.java.servlet.dao.impl.MemberApiDAOImpl;

class MemberApiDAOImplSimulator {
	private final MemberApiDAO dao = MemberApiDAOImpl.getInstance();
	
	@Test @Ignore
	void testGetMemberDual() {
		assertNotEquals(null, dao.getMemberDual());
		System.out.println( new Gson().toJson( dao.getMemberDual() ) );
	}

}
