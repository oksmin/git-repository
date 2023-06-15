package com.java.servlet.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.service.BoardApiService;
import com.java.servlet.service.impl.BoardApiServiceImpl;
import com.java.servlet.vo.BoardVO;

/**
 * Servlet implementation class BoardApiServlet
 */
@WebServlet("/api/board")
public class BoardApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final BoardApiService service = BoardApiServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardApiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private static final String BOARD_REQ_METHOD_REGISTER = "register";
	private static final String BOARD_REQ_METHOD_MODIFY = "modify";
	private static final String BOARD_REQ_METHOD_REMOVE = "remove";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		String b_no = request.getParameter("b_no");
		if( b_no == null || b_no.equals("") ) {
			b_no = "0";
		}
		vo.setB_no( Integer.parseInt( b_no ) );
		vo.setTitle( request.getParameter("title") );
		vo.setId( request.getParameter("id"));
		vo.setContent( request.getParameter("content"));
		
		//{ result : 1}
		String method = request.getParameter("method");
		int result = 0;
		
		switch (method) {
		case BOARD_REQ_METHOD_MODIFY:
			result = service.modifyBoard(vo);
			break;
		case BOARD_REQ_METHOD_REGISTER:
			result = service.registerBoard(vo);
			break;
		case BOARD_REQ_METHOD_REMOVE:
			result = service.removeBoard( Integer.parseInt( b_no ) );
			break;
		}
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		jsonObj.addProperty("method", method);
		response.getWriter().println( new Gson().toJson(jsonObj) );
	}

}
