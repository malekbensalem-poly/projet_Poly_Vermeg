package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectionDataBase.ConnectionBD;

public class User extends Person {

	private Vector<Bill> listFacture;
	private static Vector<User> tabUsers = new Vector<User>();

	public User(String nom, String prenom, int cin, int tel) {
		super(nom, prenom, cin, tel);
		this.listFacture = new Vector<Bill>();
	}

	public User(int id, String nom, int cin, int tel) {
		super(nom, cin, tel);
	}

	public User(String nom, int cin) {
		super(nom, cin);
		this.listFacture = new Vector<Bill>();

	}

	public User() {
		super();
		this.listFacture = new Vector<Bill>();

	}

	public Vector<Bill> getListFacture() {
		return listFacture;
	}

	public void setListFacture(Vector<Bill> listFacture) {
		this.listFacture = listFacture;
	}

	public String toString() {
		return "cin : " + this.getCin() + " , nom : " + this.getNom() + " , tel : " + this.getTel();
	}

	public void addUser() throws SQLException {
		this.setRole("user");
		ConnectionBD.executeRequestUpdate("Insert Into Users(nomUser,prenomUser,cinUser,telUser,roleUser)" + "Values('"
				+ this.getNom() + "','" + this.getPrenom() + "'," + "'" + this.getCin() + "','" + this.getTel() + "','"
				+ this.getRole() + "')");
	}

	public static void DeleteUser(int id) throws SQLException {
		ConnectionBD.executeRequestUpdate("Delete From Users Where idUser =" + id);
	}

	public static User findUserById(int id) throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From Users Where idUser = " + id);
		if (rs.next()) {
			return new User(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5));
		} else {
			return null;
		}
	}

	void afficherUser() {
		System.out.print(" , le Nom : " + this.getNom() + " , le prenom : " + this.getPrenom() + " , le cin :"
				+ this.getCin() + " , le Tel : " + this.getTel() + "\n");
	}

	public static void findAllUser() throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From Users where roleUser=" + "'user'");

		while (rs.next()) {
			tabUsers.add(new User(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			System.out.print("ID User : " + rs.getInt(1));
			tabUsers.lastElement().afficherUser();
		}

	}

	public static User findUserByCin(int cin) throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From Users Where cinUser = " + cin);
		if (rs.next()) {
			return new User(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
		} else {
			System.out.println("Product not dispo !!");
			return null;
		}
	}

	public static void updateUser(int id, String nom, String prenom, int cin, int tel) throws SQLException {
		ConnectionBD.executeRequestUpdate("Update users Set  nomUser = '" + nom + "',prenomUser='" + prenom
				+ "',cinUser='" + cin + "',telUser='" + tel + "' Where idUser='" + id + "';");
	}

}
