package modele;

import java.util.Vector;

public class Produit {
	

	private int idProduit ;
	private String disignation ;
	private String reference ;
	private int quantiteStock;
	private double prix ;


	

	public Produit( int idProduit , String disignation, String reference, int quantiteStock, double prix) {
		this.idProduit = idProduit ;
		this.disignation = disignation;
		this.reference = reference;
		this.quantiteStock = quantiteStock;
		this.prix = prix;
	}
	
	public Produit(String reference,double prix) {
		this.reference = reference;
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
	
	
	
	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public void afficherUnProduit() {
		System.out.println("Produit de reference = "+this.reference+", Prix = "+this.prix);
	}
	public static void afficherLesProduit(Vector<Produit> p) {
		for(int i = 0 ; i < p.size() ; i++) {
		System.out.println("idProduit "+p.get(i).getIdProduit()+" , Produit de reference = "+p.get(i).getReference()+" , Prix = "+p.get(i).getPrix());
		}
	}
	
	
	
	
	
	
}
