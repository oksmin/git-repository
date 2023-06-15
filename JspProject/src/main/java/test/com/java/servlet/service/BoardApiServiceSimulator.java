package test.com.java.servlet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.service.BoardApiService;
import com.java.servlet.service.impl.BoardApiServiceImpl;
import com.java.servlet.vo.BoardVO;

class BoardApiServiceSimulator {
	private final BoardApiService service = BoardApiServiceImpl.getInstance();
	
	@Ignore
	void testModifyBoard() {
		BoardVO vo = new BoardVO();
		vo.setB_no(1021);
		vo.setTitle("제목없음1");
		vo.setContent("내용없음1");
		assertEquals(1, service.modifyBoard(vo));
	}
	@Test @Ignore
	void testRegisterBoard() {
		BoardVO vo = new BoardVO();
		vo.setTitle("제목없음1123");
		vo.setContent("내용없음1123");
		vo.setId("jemminy01");
		assertEquals(1, service.registerBoard(vo) );
	}
	@Test @Ignore
	void testRemoveBoard() {
		
		assertEquals(1, service.removeBoard(1043) );
	}

}
