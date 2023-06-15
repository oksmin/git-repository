package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlet.service.BoardService;
import com.java.servlet.service.impl.BoardServiceImpl;
import com.java.servlet.vo.BoardVO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BoardService service = BoardServiceImpl.getInstance(); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println("method="+request.getParameter("method"));
		System.out.println("b_no="+request.getParameter("b_no"));
		String b_no = request.getParameter("b_no");
		
		if(b_no == null || b_no.equals("")) {
			b_no = "0";
		}
		RequestDispatcher dispatcher;
		BoardVO boardVO;
		switch(method) {
			case "get": 
				boardVO= service.getBoard( Integer.parseInt(b_no) );
				request.setAttribute("boardVO", boardVO);
				dispatcher = request.getRequestDispatcher("/view/board-content.jsp");
				dispatcher.forward(request, response);
				break;
			case "register": // 등록완료
				dispatcher = request.getRequestDispatcher("/view/board-content.jsp");
				dispatcher.forward(request, response);
				break;
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
