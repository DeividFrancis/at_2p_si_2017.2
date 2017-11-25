package controller.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Email;
import modal.mysql.dao.EmailDAO;

@WebServlet("/validaEmail")
public class ValidaEmailServlet extends GeralServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException, Exception {
		String email = req.getParameter("email");
		Boolean result = false;

		// Cria obj Kontato
		EmailDAO emaDao = new EmailDAO();

		if (emaDao.exist(new Email(null, null, email)))
			result = true;

		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		System.out.println(result.toString());
		res.getWriter().write(result.toString());
		return null;
	}
}
