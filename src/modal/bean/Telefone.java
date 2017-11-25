package modal.bean;

import java.math.BigDecimal;

public class Telefone {
	private Integer id;
	private Integer idPessoa;
	private String numero;
	
	
	
	public Telefone(Integer id, Integer idPessoa, String numero) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.numero = numero;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", idPessoa=" + idPessoa + ", numero=" + numero + "]";
	}
	
	public BigDecimal bananaFrita(String carro){
		
		return new BigDecimal("8");
	}
	
	
	
}
