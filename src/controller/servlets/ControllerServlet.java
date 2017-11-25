	package controller.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/decide")
public class ControllerServlet extends GeralServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String pagina = req.getParameter("pagina");

		String className = "controller.servlets." + pagina;

		// Cria classe e seta um obj do tipo
		Class<?> klas = Class.forName(className);
		GeralServlet servlet = (GeralServlet) klas.newInstance();

		// Executa uma servlet que implemento de GeralServlet e retorna a pagina
		// jsp e escolhi
		String jsp = "WEB-INF/jsp/"+servlet.doExecute(req, res);

		// Redirecion para uma pagina jsp
		req.getRequestDispatcher(jsp).forward(req, res);

		return "void";
	}

}
