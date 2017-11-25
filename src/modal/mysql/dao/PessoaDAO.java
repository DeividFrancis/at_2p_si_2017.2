package modal.mysql.dao;

import java.util.List;

import modal.bean.Pessoa;
import modal.factory.SqlFactory;

public class PessoaDAO {
	private static  SqlFactory SQL = new SqlFactory("pessoa");
//	private static String[] ALL_FIELDS = { "pes_id", "pes_nome" };

	
	public Integer getId(){
		SQL.addField("pes_id");
		
		return 9;
	}
	public Integer insert(Pessoa p) {
		SQL = new SqlFactory("pessoa");
		Integer result = null;
		try {
			String nome = p.getNome();
			
			SQL.addField("pes_nome", nome);
			result = SQL.insert();
			
		} catch (Exception e) {
			System.out.println(e);
			result = null;
		}
		
		return result;
	}
	
	public Boolean updade(Pessoa p){
		SQL = new SqlFactory("pessoa");
		Boolean result = false;
		try {
			String id = p.getId().toString();
			String nome = p.getNome();
			
			SQL.addField("pes_nome", nome);
			
			SQL.addWhere("pes_id", id);
			
			SQL.update();
			
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result = false;
		}
		return result;
	}
	
	public Boolean delete(Pessoa p){
		SQL = new SqlFactory("pessoa");
		Boolean result = false;
		String id = p.getId().toString();
		try {
			SQL.addField("pes_id");
			SQL.addField("pes_nome");
			
			SQL.addWhere("pes_id", id);
			
			SQL.delete();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
	
	public List<Pessoa> getList(){
		SQL = new SqlFactory("pessoa");
		SQL = new SqlFactory("pessoa");
		SQL.addField("pes_id");
		SQL.addField("pes_nome");
		
		List<Pessoa> pesList = SQL.select();
		return pesList;
	}
	
	public Pessoa get(Pessoa p){
		SQL = new SqlFactory("pessoa");
		SQL.addField("pes_id");
		SQL.addField("pes_nome");
		
		SQL.addWhere("pes_id", p.getId().toString());
		
		List<Pessoa> pesList = SQL.select();
		return pesList.get(0);
	}
	
	public List<Pessoa> getWhere(String query){
		SQL = new SqlFactory("pessoa");
		SQL.addField("pes_id");
		SQL.addField("pes_nome");
		
		SQL.addWhereText(query);
		
		List<Pessoa> pesList = SQL.select();
		return pesList;
	}
}
