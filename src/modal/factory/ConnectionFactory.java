package modal.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	private static String SERVER = "jdbc:mysql://localhost:3306/agenda";
	private static String USER = "root";
	private static String PASS = "arrozdoce";
	private static String DRIVE = "com.mysql.jdbc.Driver";
	
	private ConnectionFactory(){
	}
	public static ConnectionFactory newInstance(){
		return new ConnectionFactory();
	}

	public static Connection getConnection() {
		try {
			Class.forName(DRIVE);
			return DriverManager.getConnection(SERVER, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("EROOOUUU");
			throw new RuntimeException("Error ao canectar :", ex);
		}
	}

	// Fecha 1
	public static void closeConnection(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stat) {

		closeConnection(con);
		try {
			if (stat != null)
				stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, Statement st) {
		closeConnection(con);
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stat, ResultSet rs) {

		closeConnection(con, stat);
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection con, Statement st, ResultSet rs) {
		closeConnection(con, st);
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
