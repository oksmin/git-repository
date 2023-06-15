package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.BoardApiDAO;
import com.java.servlet.dao.impl.BoardApiDaoImpl;
import com.java.servlet.vo.BoardVO;

class BoardApiDaoImplSimulator {
	private final BoardApiDAO dao = BoardApiDaoImpl.getInstance();
	
	@Ignore
	void testUpdateBoard() {
		BoardVO vo = new BoardVO();
		vo.setB_no(1021);
		vo.setTitle("제목없음");
		vo.setContent("내용없음");
		assertEquals(1,  dao.updateBoard(vo));
	}
	
	@Test @Ignore
	void testDeleteBoard() {
		assertEquals(1,  dao.deleteBoard(1042));
	}
	


}
