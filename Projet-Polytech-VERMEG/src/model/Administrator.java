package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectionDataBase.ConnectionBD;

public class Administrator extends Person {

	static Vector<Product> products = new Vector<Product>();
	static Vector<User> users = new Vector<User>();

	public Administrator(String nom, String prenom, int cin, int tel) {
		super(nom, prenom, cin, tel);
	}

	public Administrator(String nom, int cin, int tel) {
		super(nom, cin, tel);
	}

	public Administrator(String nom, int cin) {
		super(nom, cin);
	}

	public Vector<Product> getProduits() {
		return products;
	}

	public void setProduits(Vector<Product> products) {
		this.products = products;
	}

	public Vector<User> getUtilisateurs() {
		return users;
	}

	public void setUtilisateurs(Vector<User> users) {
		this.users = users;
	}

	public void ajouterProduitStock(Product p) {
		products.add(p);
	}

	public static Date getDateNow() throws SQLException {
		Date d = null;
		ResultSet rs = ConnectionBD.executeRequestSelect("SELECT NOW()");
		while (rs.next()) {
			d = rs.getDate(1);
		}
		return d;
	}

}
