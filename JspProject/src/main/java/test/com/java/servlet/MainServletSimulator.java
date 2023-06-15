package test.com.java.servlet;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.MainServlet;

class MainServletSimulator {
	
	MainServlet servlet = new MainServlet();
	
	@Test @Ignore
	void testGetAllBoard() throws ServletException, IOException {
		servlet.doGet(null, null);
		
	}

}
