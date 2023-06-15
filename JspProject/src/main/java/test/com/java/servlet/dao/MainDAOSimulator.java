package test.com.java.servlet.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.dao.MainDAO;
import com.java.servlet.dao.impl.MainDAOImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.BoardVO;

class MainDAOSimulator {
	
	private final MainDAO dao = MainDAOImpl.getInstance();
	
	@Test @Ignore
	void testSelectAllBoard() {
		List<BoardVO> list = dao.selectAllBoard();
		
		assertNotEquals(null, list);
		
		System.out.println(list);
	}

	/* @Test */ @Ignore
	void testSelectCountAllBoard() {
		int result = dao.seletCountAllBoard();
		assertNotEquals(0, result);
		
		System.out.println("totalCount : "+result);
	}
	
	@Test  @Ignore 
	void testSelectAllBoardByPage() {
		
		Criteria cri = new Criteria(1, 10); //현재페이지, 한페이지당 출력갯수
		PageMaker pageMaker = new PageMaker(cri, 101); // cri, totalCount=100
		pageMaker.setDisplayPageAmount(10);
		System.out.println(pageMaker);
		
		List<BoardVO> boardList  = dao.selectAllBoardByPage(pageMaker);
		System.out.println(boardList);
		assertNotEquals(null, boardList);
		
		System.out.println("boardList per Page : "+boardList);
	}

}
