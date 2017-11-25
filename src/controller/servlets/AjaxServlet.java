package controller.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class AjaxServlet extends GeralServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException, Exception {
		// TODO Auto-generated method stub
		String nome = req.getParameter("userName");
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(nome);
		return null;
	}

}
