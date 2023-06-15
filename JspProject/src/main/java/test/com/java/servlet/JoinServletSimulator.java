package test.com.java.servlet;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import javax.servlet.ServletException;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.java.servlet.JoinServlet;


class JoinServletSimulator {
	
	JoinServlet servlet = new JoinServlet();
	
	@Test @Ignore
	void testDoPost() throws ServletException, IOException {
		servlet.doPost(null, null);
	}
}
