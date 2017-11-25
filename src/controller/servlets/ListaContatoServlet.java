package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Kontato;
import modal.mysql.dao.KontatoDAO;

@WebServlet("/contato/lista")
public class ListaContatoServlet extends GeralServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		// Pega todos os contatos do DB
		KontatoDAO dao = new KontatoDAO();
		List<Kontato> contatoList = dao.getList();

		/*
		 * Quarda Valores no Request para quando o jsp executa fique TOPSTER
		 * */
		req.setAttribute("contatos", contatoList);
		
		return "tabela-contato.jsp";

	}
}
