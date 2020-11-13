package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectionDataBase.ConnectionBD;

public class Product {

	private String disignation;
	private String reference;
	private int quantiteStock;
	private double prix;
	private String type;
	private static Vector<Product> tabProducts = new Vector<Product>();

	public Product(String disignation, String reference, int quantiteStock, double prix) {
		this.disignation = disignation;
		this.reference = reference;
		this.quantiteStock = quantiteStock;
		this.prix = prix;
	}

	public Product(String disignation, String reference, int quantiteStock, double prix, String type) {
		this.disignation = disignation;
		this.reference = reference;
		this.quantiteStock = quantiteStock;
		this.prix = prix;
		this.type = type;
	}

	public Product(int quantiteStock, double prix) {
		this.quantiteStock = quantiteStock;
		this.prix = prix;
	}

	public String getDisignation() {
		return disignation;
	}

	public void setDisignation(String disignation) {
		this.disignation = disignation;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	void afficherProduct() {
		System.out.print(" , la Designation : " + this.getDisignation() + " , la reference : " + this.getReference()
				+ " , la qt Stock :" + this.getQuantiteStock() + " , le prix : " + this.getPrix() + "\n");
	}

	public static double getPrixProductById(int id) throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select productPrice From product Where idProduct = " + id);
		if (rs.next()) {
			return rs.getDouble(1);
		} else {
			return 0;
		}
	}

	public static void findAllProduit() throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From product ;");
		while (rs.next()) {
			tabProducts.add(new Product(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
			System.out.print("ID Product : " + rs.getInt(1));
			tabProducts.lastElement().afficherProduct();
		}
	}

	public static void DeleteProduct(int id) throws SQLException {
		ConnectionBD.executeRequestUpdate("Delete From product Where idProduct =" + id);
	}

}
