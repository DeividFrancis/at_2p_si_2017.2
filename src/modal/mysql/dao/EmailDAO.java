package modal.mysql.dao;

import java.util.ArrayList;
import java.util.List;

import modal.bean.Email;
import modal.factory.SqlFactory;

public class EmailDAO {

	SqlFactory SQL = new SqlFactory("email");

	public Integer insert(Email e) {
		SQL = new SqlFactory("email");
		Integer result = null;
		String idPessoa = e.getIdPessoa().toString();
		String email = e.getEmail();

		try {
			SQL.addField("ema_id_pessoa", idPessoa);
			SQL.addField("ema_email", email);
			result = SQL.insert();
		} catch (Exception e2) {
			System.out.println("Erro no EmailDao: " + e2);
		}
		return result;
	}

	public Boolean update(Email e) {
		SQL = new SqlFactory("email");
		Boolean result = null;
		
		String emailNew = e.getEmail();
		String idPessoa = e.getIdPessoa().toString();
		try {
			SQL.addField("ema_email", emailNew);
			
			SQL.addWhere("ema_id_pessoa", idPessoa);
//			SQL.addWhere("ema_email", emailOld);
			
			result = true;
		} catch (Exception e2) {
			System.out.println("Erro: "+ e2);
		}
		return result;
	}

	public Boolean delete(Email e) {
		SQL = new SqlFactory("email");
		Boolean result = null;
		String id = e.getIdPessoa().toString();
		String email = e.getEmail();
		
		try {
			SQL.addField("ema_id_pessoa");
			SQL.addField("ema_email");
			
			SQL.addWhere("ema_id_pessoa", id);
			SQL.addWhere("ema_email", email);
			
			SQL.delete();
			result = true;
			
		} catch (Exception e2) {
			System.out.println("Erro: " + e2);
		}
		
		return result;
	}

	public List<Email> getList() {
		SQL = new SqlFactory("email");
		List<Email> emailList = new ArrayList<Email>();
		
		try {
			SQL.addField("ema_id");
			SQL.addField("ema_id_pessoa");
			SQL.addField("ema_email");
			
			emailList = SQL.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emailList;
	}
	public List<Email> get(Email e) {
		SQL = new SqlFactory("email");
		List<Email> emailList = new ArrayList<Email>();
		
		try {
			SQL.addField("ema_id");
			SQL.addField("ema_id_pessoa");
			SQL.addField("ema_email");
			
			SQL.addWhere("ema_id_pessoa", e.getIdPessoa().toString());
			
			emailList = SQL.select();
		} catch (Exception e2) {
		}
		
		return emailList;
	}
	
	public Boolean exist(Email e){
		SQL = new SqlFactory("email");
		Boolean result = false;
		
		SQL = new SqlFactory("email");
		SQL.addField("ema_id");
		SQL.addField("ema_id_pessoa");
		SQL.addField("ema_email");
		SQL.addWhere("ema_email", e.getEmail());
		
		List<Email> listEmail = SQL.select();
		if(listEmail.size() > 0)
			result = true;
		
		return result;
	}

}
