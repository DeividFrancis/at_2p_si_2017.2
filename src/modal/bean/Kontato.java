package modal.bean;

import java.util.List;

public class Kontato {

	private Pessoa pessoa;
	private List<Telefone> telefoneList;
	private List<Email> emailList;
	
	public Kontato(){
		
	}

	public Kontato(Pessoa pessoa, List<Telefone> telefoneList, List<Email> emailList) {
		super();
		this.pessoa = pessoa;
		this.telefoneList = telefoneList;
		this.emailList = emailList;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Telefone> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(List<Telefone> telefoneList) {
		this.telefoneList = telefoneList;
	}

	public List<Email> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}

	@Override
	public String toString() {
		return "Kontato [pessoa=" + pessoa + ", telefoneList=" + telefoneList + ", emailList=" + emailList + "]";
	}
	

	

}
