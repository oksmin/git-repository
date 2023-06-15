package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.BoardDAO;
import com.java.servlet.dao.impl.BoardDAOImpl;

class BoardDAOImplSimulator {
	private final BoardDAO dao = BoardDAOImpl.getInstance();
	@Test @Ignore
	void testSelectBoard() {
		int b_no = 1022;
		assertNotEquals(null, dao.selectBoard(b_no));
		System.out.println(dao.selectBoard(b_no));
	}

}
