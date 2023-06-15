package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.MemberDAO;
import com.java.servlet.dao.impl.MemberDAOImpl;
import com.java.servlet.util.DBCP2Util;

class MemberDAOSimulator {
	
	MemberDAO dao = new MemberDAOImpl();
	
	@Test @Ignore
	void testSelectMemberList() throws ClassNotFoundException, SQLException, NamingException {
		// assertArrayEquals(a, b)
		// assertEquals(a, b)
		// assertSame(a,b)
		// assertTrue(a)
		// assertFalse(a)
		// assertNotNull(a)
		//DBCP2Util.testInit();
		assertNotNull(dao.selectMemberList());
	}

}
