package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Kontato;
import modal.bean.Pessoa;
import modal.mysql.dao.KontatoDAO;

@WebServlet("/contato/remover")
public class DeletaContatoServlet extends GeralServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		String[] id = null;
		String nome = req.getParameter("nome" );
		String result = null;

		id = req.getParameterValues("idPessoa");

		for (String key : id) {
			if (!key.equals("null")) {
				KontatoDAO dao = new KontatoDAO();
				Kontato k = new Kontato();
				k.setPessoa(new Pessoa(Integer.parseInt(key), null));
				if (dao.delete(k))
					result = nome + " removido";

			} else {
				result = "Nenhum Contato Selecionado";
			}
		}

		// Ajax
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		out.write(result);

		return "";

	}

}
