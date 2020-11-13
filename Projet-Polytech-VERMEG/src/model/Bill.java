package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectionDataBase.ConnectionBD;

public class Bill {

	static Vector<LineCommand> tabLineCommand = new Vector<LineCommand>();
	static Vector<Bill> tabBill = new Vector<Bill>();
	private int idUser;
	private double total;
	private Date date;

	public Bill(Vector<LineCommand> tabLineCommand) {
		this.tabLineCommand = tabLineCommand;
	}

	public Bill(int idUser, Date date) {
		this.idUser = idUser;
		this.total = 0;
		this.date = date;
	}

	public Bill(Date date) {
		this.date = date;
	}

	public Bill(int int1, double double1, Date date2) {
		this.idUser = int1;
		this.total = double1;
		this.date = date2;
	}

	public Vector<LineCommand> getAchat() {
		return tabLineCommand;
	}

	public void setAchat(Vector<LineCommand> tabLineCommand) {
		this.tabLineCommand = tabLineCommand;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static double calculerTotalPrix(Vector<LineCommand> achat) throws SQLException {
		double s = 0;
		for (int j = 0; j < achat.size(); j++) {
			s += achat.get(j).getQuatite() * Product.getPrixProductById(achat.get(j).getIdProduit());
		}
		return s;
	}

	public void afficherBill() {
		System.out.print(" , idUser : " + this.getIdUser() + " , le prix totale : " + this.getTotal() + " , la date :"
				+ this.getDate() + "\n");

	}

	public int getLastID() throws SQLException {
		int id_bill = 0;
		ResultSet rs = ConnectionBD.executeRequestSelect("SELECT idBill FROM Bill ORDER BY idBill DESC LIMIT 0, 1");
		while (rs.next()) {
			id_bill = rs.getInt(1);
		}

		return id_bill;

	}

	public void addBill() throws SQLException {

		ConnectionBD.executeRequestUpdate("Insert Into Bill(idUser,date,totalPrice)" + "Values('" + this.getIdUser()
				+ "','" + this.getDate() + "','" + this.getTotal() + "')");

	}

	public static Vector<LineCommand> findLineCommandByBill(int id) throws SQLException {
		Vector<LineCommand> v = new Vector<LineCommand>();
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From lineCommande Where idBill = " + id);
		while (rs.next()) {
			v.add(new LineCommand(rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			tabLineCommand.add(new LineCommand(rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			System.out.print("ID LineCommand : " + rs.getInt(1));
			tabLineCommand.lastElement().afficherLineCommand();
		}
		return v;
	}

	public static void DeleteBill(int id) throws SQLException {
		ConnectionBD.executeRequestUpdate("Delete From bill Where idBill =" + id);
		ConnectionBD.executeRequestUpdate("Delete From lineCommande Where idBill =" + id);
	}

	public static void findBillByIdUser(int id) throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From Bill Where idUser = " + id);
		while (rs.next()) {
			tabBill.add(new Bill(rs.getInt(2), rs.getDouble(4), rs.getDate(3)));
			System.out.print("ID Bill : " + rs.getInt(1));
			tabBill.lastElement().afficherBill();
		}
	}

	public static void findAllBill() throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From Bill ");
		while (rs.next()) {
			tabBill.add(new Bill(rs.getInt(2), rs.getDouble(4), rs.getDate(3)));
			System.out.print("ID Bill : " + rs.getInt(1));
			tabBill.lastElement().afficherBill();
		}
	}

	public static Bill findBillById(int id) throws SQLException {
		ResultSet rs = ConnectionBD.executeRequestSelect("Select * From Bill Where idBill = " + id);
		if (rs.next()) {
			return new Bill(rs.getInt(2), rs.getDouble(4), rs.getDate(3));
		} else {
			return null;
		}
	}

}
