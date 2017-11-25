package modal.mysql.dao;

import java.util.List;

import modal.bean.Telefone;
import modal.factory.SqlFactory;

public class TelefoneDAO {

	private SqlFactory SQL = new SqlFactory("telefone");

	public Boolean insert(Telefone t) {
		SQL = new SqlFactory("telefone");
		Boolean result = false;
		try {
			Integer idPessoa = t.getIdPessoa();
			String telefone = t.getNumero();

			SQL.addField("tel_id_pessoa", idPessoa.toString());
			SQL.addField("tel_telefone", telefone);

			SQL.insert();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
	
	public Boolean update(Telefone t){
		SQL = new SqlFactory("telefone");
		Boolean result = false;
		try {
			Integer idPessoa = t.getIdPessoa();
			String telefone = t.getNumero();
			
			SQL.addField("tel_telefone", telefone);
			
			SQL.addWhere("tel_id_pessoa", idPessoa.toString());
			SQL.addWhere("tel_telefone", telefone);
			SQL.update();
			result = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public Boolean delete(Telefone t){
		SQL = new SqlFactory("telefone");
		Boolean result = false;
		String id = t.getIdPessoa().toString();
		String tel = t.getNumero();
		try {
			SQL.addField("tel_id");
			SQL.addField("tel_id_pessoa");
			SQL.addField("tel_telefone");
			
			SQL.addWhere("tel_id_pessoa", id);
			SQL.addWhere("tel_telefone", tel);
			
			SQL.delete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public List<Telefone> get(Telefone t){
		SQL = new SqlFactory("telefone");
		try {
			SQL.addField("tel_id");
			SQL.addField("tel_id_pessoa");
			SQL.addField("tel_telefone");
			
			SQL.addWhere("tel_id_pessoa", t.getIdPessoa().toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
//		List<String> telefoneList = SQL.select();
		return  SQL.select();
	}
	
	public List<Telefone> get(){
		SQL = new SqlFactory("telefone");
		SQL.addField("tel_id");
		SQL.addField("tel_id_pessoa");
		SQL.addField("tel_telefone");
		
		return SQL.select();
	}
}
