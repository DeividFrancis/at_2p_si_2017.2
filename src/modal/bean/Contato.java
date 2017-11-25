package modal.bean;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	
	private Integer id;
	private String nome;
	private List<String> telefone;
	private List<String> email;
	
	
	public Contato(){
		
	}
	
	public Contato(Integer id, String nome, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = split(telefone);
		this.email = split(email);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
	}
	
	private List<String> split(String s){
		List<String> list = new ArrayList<String>();
		
		String[] array = s.split("/");
		
		for (String key : array) {
			list.add(key);
		}
		
		return list;
	}
	
	
}
