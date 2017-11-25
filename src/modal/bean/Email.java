package modal.bean;

public class Email {

	private Integer id;
	private Integer idPessoa;
	private String email;

	public Email(Integer id, Integer idPessoa, String email) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.email = email;
	}

	public Email() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", idPessoa=" + idPessoa + ", email=" + email + "]";
	}

}
