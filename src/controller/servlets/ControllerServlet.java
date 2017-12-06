package controller.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/decide"})
public class ControllerServlet extends GeralServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String pagina = req.getParameter("pagina");

		String className = "controller.servlets." + pagina;
		
		 String jsp = "WEB-INF/jsp/";
		try {
			// Cria classe e seta um obj do tipo
			Class<?> klas = Class.forName(className);
			GeralServlet servlet = (GeralServlet) klas.newInstance();
			
			 // Executa uma servlet que implemento de GeralServlet e retorna a pagina
			 // jsp e escolhi
			jsp  =  jsp + servlet.doExecute(req, res);
		} catch (Exception e) {
			jsp = jsp + "error404.jsp";
		}finally {
			// Redirecion para uma pagina jsp
		}
		req.getRequestDispatcher(jsp).forward(req, res);


		return "void";
	}

}
