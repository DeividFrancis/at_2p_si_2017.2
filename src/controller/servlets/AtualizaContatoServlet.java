package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.bean.Email;
import modal.bean.Kontato;
import modal.bean.Pessoa;
import modal.bean.Telefone;
import modal.mysql.dao.KontatoDAO;

@WebServlet("/up/contato")
public class AtualizaContatoServlet extends GeralServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		//DataBase
		KontatoDAO konDao = new KontatoDAO();
		
		Integer idPessoa = Integer.parseInt(req.getParameter("idPessoa"));
		String nome = req.getParameter("nome");
		
		//Telefones
		String tel = req.getParameter("telefone");
		String[] telefones = tel.split(",");
		List<Telefone> telList = new ArrayList<Telefone>();
		for (String t : telefones)
			telList.add(new Telefone(null, null, t));
		
		//Email
		String ema = req.getParameter("email");
		String[] emails = ema.split(",");
		
		List<Email> emaList = new ArrayList<Email>();
		for (String e : emails)
			emaList.add(new Email(null, null, e));
		
		Pessoa pes = new Pessoa(idPessoa,nome);
		
		Boolean status = false;
		try {
			
			Kontato k = new Kontato(pes,telList,emaList);
			konDao.updade(k);
			status = true;
		} catch (Exception e) {
		}
		
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(status.toString());

		req.setAttribute("status", status);
		return "tabela-contato.jsp";
	}
}
