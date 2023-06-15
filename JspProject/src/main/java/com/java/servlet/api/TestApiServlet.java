package com.java.servlet.api;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class TestApiServlet
 */
@WebServlet("/api/test")
public class TestApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * REST API Get Method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		String name = request.getParameter("name") ;
		String lastName = request.getParameter("lastName");
		String opKey = request.getParameter("opKey");
		int responseCode = 0;
		
		if(opKey == null) {
			responseCode = 300;
			name = "";
			lastName = "";
		}else if(!opKey.equals("123") ) {
			responseCode = 400;
			name = "";
			lastName = "";
		}else {
			responseCode = 200;
		}
		
		// return 값 만들기 json
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("name", name+"-re");
		jsonObj.addProperty("lastName", lastName+"-re");
		jsonObj.addProperty("responseCode", responseCode);
		
		
		response.getWriter().println( new Gson().toJson(jsonObj) );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * REST API Post Method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
