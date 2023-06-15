package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.BoardService;
import com.java.servlet.service.impl.BoardServiceImpl;

class BoardServiceImplSimulator {
	private final BoardService service = BoardServiceImpl.getInstance(); 
	
	
	@Test @Ignore
	void testGetBoard() {
		int b_no = 1022;
		assertNotEquals(null, service.getBoard(b_no));
		System.out.println(service.getBoard(b_no));
	}

}
