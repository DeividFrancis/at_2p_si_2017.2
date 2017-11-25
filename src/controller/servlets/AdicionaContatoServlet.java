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

@WebServlet("/add/contato")
public class AdicionaContatoServlet extends GeralServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6399392592812130522L;

	public String doExecute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		new AdicionaContatoServlet();

		String result = "adicionaContato.jsp";
		String status = null;
		Boolean xx = false;

		// Pega Dados dos inputs do contato
		String nome = req.getParameter("nome");
		String tel = req.getParameter("telefone");
		String[] telefones = tel.split(",");

		System.out.println(req.getParameter("nome"));
		String ema = req.getParameter("email");
		String[] emails = ema.split(",");

		List<Telefone> telList = new ArrayList<Telefone>();
		for (String t : telefones)
			telList.add(new Telefone(null, null, t));
		if (true)
			System.out.println("gugu");

		List<Email> emaList = new ArrayList<Email>();
		for (String e : emails)
			emaList.add(new Email(null, null, e));

		// Cria obj Kontato
		Kontato k = new Kontato();
		k.setPessoa(new Pessoa(null, nome));
		k.setTelefoneList(telList);
		k.setEmailList(emaList);

		// Cadastra no Banco de Dados
		try {
			KontatoDAO konDao = new KontatoDAO();

			konDao.insert(k);
			status = "Salvo com sucesso!";
			xx = true;
		} catch (Exception e) {
			status = "Erro ao salvar no Banco de Dados!";
		}

		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(xx.toString());

		req.setAttribute("status", status);

		return result;
	}

}
