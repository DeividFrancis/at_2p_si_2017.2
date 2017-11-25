package modal.bean;

public interface Bean {
	
	
	public Integer getId();
	public Integer getIdPessoa();
	public String  getNome();
	public String  getTelefone();
	public String  getEmail();
	
	public Integer setId(Integer id);
	public Integer setIdPessoa(Integer idPessoa);
	public String  setNome(String nome);
	public String  setTelefone(String telefone);
	public String  setEmail(String email);
}
