package controller.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error404 extends GeralServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException, Exception {
		return "error404.jsp";
	}
}
