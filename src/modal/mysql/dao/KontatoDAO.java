package modal.mysql.dao;

import java.util.ArrayList;
import java.util.List;

import modal.bean.Email;
import modal.bean.Kontato;
import modal.bean.Pessoa;
import modal.bean.Telefone;

public class KontatoDAO {

	PessoaDAO pesDao = new PessoaDAO();
	TelefoneDAO telDao = new TelefoneDAO();
	EmailDAO emaDao = new EmailDAO();

	public Boolean insert(Kontato k) {

		Pessoa p = k.getPessoa();
		List<Telefone> telList = k.getTelefoneList();
		List<Email> emaList = k.getEmailList();

		// Recupera o id inserido
		Integer pesId = pesDao.insert(p);

		// Adiciona o id no objeto pessoa
		p.setId(pesId);

		// Adiciona um por um no DB
		for (Telefone t : telList) {
			t.setIdPessoa(p.getId());
			telDao.insert(t);
		}

		for (Email e : emaList) {
			e.setIdPessoa(p.getId().intValue());
			emaDao.insert(e);
		}
		return false;
	}
	
	
	// Forma incorreta pois devo passar tbm o old para substituir polo new
	public void updade(Kontato k) {
		Pessoa p = k.getPessoa();
		List<Telefone> telList = k.getTelefoneList();
		List<Email> emaList = k.getEmailList();

		pesDao.updade(p);

		// Adiciona um por um no DB
		for (Telefone t : telList) {
			t.setIdPessoa(p.getId());
			telDao.update(t);
		}

		for (Email e : emaList) {
			e.setIdPessoa(p.getId().intValue());
			emaDao.update(e);
		}

	}

	public Boolean delete(Kontato k) {
		Boolean result = false;
		Kontato konDao = get(k);
		Pessoa p = konDao.getPessoa();

		List<Telefone> telList = konDao.getTelefoneList();
		List<Email> emaList = konDao.getEmailList();

		Integer id = p.getId();
		System.out.println(id);

		// Remove um por um no DB
		try {
			for (Telefone t : telList)
				telDao.delete(t);
			for (Email e : emaList)
				emaDao.delete(e);
			pesDao.delete(p);
			result = true;
		} catch (Exception e) {
		}
		return result;
	}

	public Kontato get(Kontato k) {

		Pessoa p = k.getPessoa();
		Telefone t = new Telefone(null, p.getId(), null);
		Email e = new Email(null, p.getId(), null);

		p = pesDao.get(p);
		List<Telefone> telList = telDao.get(t);
		List<Email> emaList = emaDao.get(e);

		return new Kontato(p, telList, emaList);
	}

	public List<Kontato> getList(){
		
		// Objetos Unicos
		PessoaDAO pesDao = new PessoaDAO();
		TelefoneDAO telDao = new TelefoneDAO();
		EmailDAO emaDao = new EmailDAO();
		
		//Array de Obejtos
		List<Pessoa> pesList = pesDao.getList();
		List<Kontato> konList = new ArrayList<Kontato>();
		
		for(Pessoa p : pesList){
			Integer id = p.getId();
			List<Telefone> telList = telDao.get(new Telefone(null, id , null));
			List<Email> emaList = emaDao.get(new Email(null, id,null));
			
			konList.add(new Kontato(p, telList, emaList));
		}
		return konList;
	}
}
