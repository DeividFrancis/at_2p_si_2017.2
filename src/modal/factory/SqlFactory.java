package modal.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modal.bean.Email;
import modal.bean.Pessoa;
import modal.bean.Telefone;

public class SqlFactory extends QueryFactory {

	
	public SqlFactory(String table) {
		super(table);
		// TODO Auto-generated constructor stub
	}

	public Integer insert() {
		System.out.println(sqlInsert());
		return doExecuteGetLastId(sqlInsert());
	}

	public <T> List<T> select(){
		return doExecuteGet(sqlSelect());
	}

	public <T> List<T> selectGet(){
		return doExecuteGet(sqlQuery());
	}

	public void update() {
		doExecute(sqlUpdate());
	}

	public void delete() {
		doExecute(sqlDelete());
	}

	private void doExecute(String query) {
		ConnectionFactory.newInstance();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			System.out.println("Query = " + query);
			stmt = con.prepareStatement(query);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> doExecuteGet(String query){

		ConnectionFactory.newInstance();

		Connection con = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		List<T> result = new ArrayList<T>();
		try {
			stmt = con.createStatement();
			System.out.println("Get=" + query);
			rs = stmt.executeQuery(query);

			String tabela = getTableName();

			if (tabela.equals("pessoa")) {
				result = (List<T>) rsPessoa(rs);
			} else if (tabela.equals("telefone")) {
				result = (List<T>) rsTelefone(rs);
			} else if (tabela.equals("email")) {
				result = (List<T>) rsEmail(rs);
			} else {
				System.out.println("Tabela nao encontrada");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return result;
	}

	private Integer doExecuteGetLastId(String query) {

		ConnectionFactory.newInstance();

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer lastId = null;
		try {
			stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next())
				lastId = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return lastId;
	}

	private List<Pessoa> rsPessoa(ResultSet rs) throws SQLException {
		List<Pessoa> list = new ArrayList<Pessoa>();
		while (rs.next()) {
			Integer id = rs.getInt("pes_id");
			String nome = rs.getString("pes_nome");

			list.add(new Pessoa(id, nome));
		}
		return list;
	}

	private List<Telefone> rsTelefone(ResultSet rs) throws SQLException {
		List<Telefone> list = new ArrayList<Telefone>();
		while (rs.next()) {
			Integer id = rs.getInt("tel_id");
			Integer idPessoa = rs.getInt("tel_id_pessoa");
			String telefone = rs.getString("tel_telefone");

			list.add(new Telefone(id, idPessoa, telefone));
		}
		return list;
	}

	private List<Email> rsEmail(ResultSet rs) throws SQLException {
		List<Email> list = new ArrayList<Email>();
		while (rs.next()) {
			Integer id = rs.getInt("ema_id");
			Integer idPessoa = rs.getInt("ema_id_pessoa");
			String email = rs.getString("ema_email");

			list.add(new Email(id, idPessoa, email));
		}
		return list;
	}
}
