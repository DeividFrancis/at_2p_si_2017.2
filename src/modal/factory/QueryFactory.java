package modal.factory;

import java.util.ArrayList;
import java.util.List;

public class QueryFactory {
	private String table;
	private StringBuilder query;
	public List<String> fields = new ArrayList<String>();
	private List<String> values = new ArrayList<String>();
	private List<String> where = new ArrayList<String>();

	public QueryFactory(String table){
		this.table = table;
	}

	public String getTableName() {
		return table;
	}

	public void addField(String field, String values) {
		this.fields.add(field);
		this.values.add(values);
	}

	public void addField(String field) {
		addField(field, null);
	}

	public void addWhere(String field, String value) {
		if (where.size() == 0) {
			where.add("WHERE " + field + " = '" + value + "' ");
		} else {
			where.add(where.get(where.size() - 1) + " AND " + field + " = '" + value + "'");
		}
	}

	public void addWhereText(String qry) {
		where.add(qry);
	}

	public void addQuery(String qry) {
		query = new StringBuilder();
		query.append(qry);
	}

	// Montando Querys

	public String sqlInsert() {
		query = new StringBuilder();
		query.append("INSERT INTO ");
		query.append(table);
		query.append(" (");

		// Concatena todos os campos da tabela;
		for (int i = 0; i < fields.size(); i++) {
			query.append((i == fields.size() - 1 ? " " + fields.get(i) : " " + fields.get(i) + ","));
		}

		query.append(") VALUES (");

		for (int i = 0; i < values.size(); i++) {
			String value = values.get(i);
			if (numero(value)){
				query.append((i == values.size() - 1) ? " " + value : " " + value + ",");
			}else{
				query.append((i == values.size() - 1) ? " '" + value + "'" : " '" + value + "',");
			}
		}

		query.append(")");

		return query.toString();
	}

	public String sqlDelete() {
		query = new StringBuilder();
		query.append("DELETE FROM ");
		query.append(table);

		if (where.size() != 0)
			query.append(" " + where.get(where.size() - 1));

		return query.toString();
	}

	public String sqlUpdate() {
		query = new StringBuilder();
		query.append("UPDATE ");
		query.append(table);
		query.append(" SET ");

		for (int i = 0; i < fields.size(); i++) {
			query.append(fields.get(i) + " = '");
			query.append(values.get(i) + "'");
			if (i != fields.size() - 1)
				query.append(", ");
		}

		if (where.size() != 0)
			query.append(" " + where.get(where.size() - 1));
		return query.toString();
	}

	public String sqlSelect() {
		query = new StringBuilder();
		query.append("SELECT ");

		for (int i = 0; i < fields.size(); i++) {
			query.append(i == fields.size() - 1 ? fields.get(i) : fields.get(i) + ",");
		}
		query.append(" FROM ");
		query.append(table);

		if (where.size() != 0)
			query.append(" " + where.get(where.size() - 1));
		return query.toString();
	}

	public String sqlQuery() {
		return query.toString();
	}

	// public String sqlSelect(){
	// query = new StringBuilder();
	// return query.toString();
	// }
	private Boolean numero(String value) {

		Boolean result = false;

		try {
			Integer.parseInt(value);
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}
}
