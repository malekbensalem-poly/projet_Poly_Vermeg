package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectionDataBase.ConnectionBD;

import java.sql.Date;

public class Book extends Product {

	private String title;
	private String author;
	private Date dateEdition;
	static Vector<Book> tabBooks = new Vector<Book>();

	public Book(String disignation, String reference, int quantiteStock, double prix, String title, String author,
			Date dateEdition) {
		super(disignation, reference, quantiteStock, prix);
		this.title = title;
		this.author = author;
		this.dateEdition = dateEdition;
	}

	public Book(int id, int quantiteStock, double prix, String title, String author, Date dateEdition) {
		super(quantiteStock, prix);
		// this.id = id ;
		this.title = title;
		this.author = author;
		this.dateEdition = dateEdition;
	}

	public Book(int id, double prix) {
		super(id, prix);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public java.sql.Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	public String toString() {
		return "Title of book : " + this.getTitle() + " , Author : " + this.getAuthor() + " , And price = "
				+ this.getPrix();
	}

	void afficherBook() {
		System.out.print(" , la Designation : " + this.getDisignation() + " , la reference : " + this.getReference()
				+ " , la qt Stock :" + this.getQuantiteStock() + " , le prix : " + this.getPrix() + "\n");
	}

	public void addBook() throws SQLException {

		this.setType("book");
		ConnectionBD.executeRequestUpdate(
				"Insert Into Product(productDesignation,productReference,productQuantityStock,productPrice,"
						+ "productType,titleBook,authorBook,dateEditionBook)" + "Values('" + this.getDisignation()
						+ "','" + this.getReference() + "'" + ",'" + this.getQuantiteStock() + "','" + this.getPrix()
						+ "','" + this.getType() + "'" + ",'" + this.getTitle() + "','" + this.getAuthor() + "','"
						+ this.getDateEdition() + "')");

	}

	public static void DeleteBook(int id) throws SQLException {
		ConnectionBD.executeRequestUpdate("Delete From product Where idProduct =" + id);
	}

	public static void updatePriceAndQuantiteStockOfBook(int id, Double price, int qtStock) throws SQLException {
		ConnectionBD.executeRequestUpdate("Update product Set  productQuantityStock = '" + qtStock + "',productPrice='"
				+ price + "' Where idProduct='" + id + "';");
	}

	public static void updatePriceOfBook(int id, Double price) throws SQLException {
		ConnectionBD
				.executeRequestUpdate("Update product Set productPrice='" + price + "' Where idProduct='" + id + "';");
	}

	public static void updateQuantityStockOfBook(int id, int qtStock) throws SQLException {
		ConnectionBD.executeRequestUpdate(
				"Update product Set productQuantityStock='" + qtStock + "' Where idProduct='" + id + "';");
	}

	public static void findAllBook() throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From product where productType=" + "'book'");
		while (rs.next()) {
			tabBooks.add(new Book(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(7),
					rs.getString(8), rs.getDate(9)));
			System.out.print("ID Livre : " + rs.getInt(1));
			tabBooks.lastElement().afficherBook();
		}
	}

	public static Book findBookById(int id) throws java.lang.NullPointerException, SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect(
				"Select * From product Where productType = " + "'book'" + " and idProduct = " + id);
		if (rs.next()) {
			return new Book(rs.getInt(1), rs.getInt(4), rs.getDouble(5), rs.getString(2), rs.getString(3),
					rs.getDate(9));
		} else {
			System.out.println("Book not dispo !!");
			return null;
		}

	}

}
