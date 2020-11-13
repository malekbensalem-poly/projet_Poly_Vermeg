package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connectionDataBase.ConnectionBD;

public class LineCommand {

	private int idFacture;
	private int idProduit;
	private int quatite;

	public LineCommand(int idFacture, int idProduit, int quatite) {
		this.idFacture = idFacture;
		this.idProduit = idProduit;
		this.quatite = quatite;
	}

	public LineCommand(int idFacture, int idProduit, int quantite, int p) {
		this.idFacture = idFacture;
		this.idProduit = idProduit;
		this.quatite = quantite;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getQuatite() {
		return quatite;
	}

	public void setQuatite(int quatite) {
		this.quatite = quatite;
	}

	public String toString() {
		return "LigneCommande : " + " idFacture : " + this.getIdFacture() + " idProduit : " + this.getIdProduit()
				+ " Quantite : " + this.getQuatite();
	}

	void afficherLineCommand() {
		System.out.print(" , idBill : " + this.getIdFacture() + " , idProduct : " + this.getIdProduit()
				+ " , Quantite :" + this.getQuatite() + "\n");
	}

	public void addLineCommand() throws SQLException {
		ConnectionBD.executeRequestUpdate("Insert Into lineCommande(idBill,idProduct,quantity)" + "Values('"
				+ this.getIdFacture() + "'," + "'" + this.getIdProduit() + "','" + this.getQuatite() + "')");

	}

	public static void DeleteLineCommand(int id) throws SQLException {
		ConnectionBD.executeRequestUpdate("Delete From LineCommande Where idLineCommand =" + id);
	}
}
