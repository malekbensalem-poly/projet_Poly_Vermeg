package connectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionBD {

	static Connection connection = null;
	private static final ConnectionBD instance = new ConnectionBD();

	private ConnectionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du Driver !!!");
			e.printStackTrace();
			return;
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
		} catch (SQLException e) {
			System.out.println("Erreur de connection avec cette url , username et mot de passe");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("Connection etablit avec succes!");
		} else {
			System.out.println("Erreur d'etablir une connection !");
		}
	}

	public static final Connection getInstance() {
		return connection;
	}

	public static int executeRequestUpdate(String rq) throws SQLException {
		PreparedStatement stmt = ConnectionBD.getInstance().prepareStatement(rq);
		return stmt.executeUpdate();
	}

	public static ResultSet executeRequestSelect(String rq) throws SQLException {
		PreparedStatement stmt = ConnectionBD.getInstance().prepareStatement(rq);
		return stmt.executeQuery();
	}

}
